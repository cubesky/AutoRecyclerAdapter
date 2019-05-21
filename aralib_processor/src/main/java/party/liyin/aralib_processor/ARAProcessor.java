package party.liyin.aralib_processor;

import com.google.auto.service.AutoService;
import com.squareup.javapoet.ArrayTypeName;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.CodeBlock;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterSpec;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeSpec;
import com.squareup.javapoet.TypeVariableName;
import com.squareup.javapoet.WildcardTypeName;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.MirroredTypeException;
import javax.lang.model.type.MirroredTypesException;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;
import javax.tools.Diagnostic;

import party.liyin.aralib.ARABind;
import party.liyin.aralib.ARABindLayout;

@AutoService(Processor.class)
public class ARAProcessor extends AbstractProcessor {
    boolean isTransformed = false;
    private Filer mFiler;
    private Messager mMessager;
    private Types mTypes;
    private Elements mElements;
    private int nextLayoutID = 0;
    private String packageName = "liyin.party.skyrecycleradapter";
    private String araName = "SmartRecyclerAdapter";

    @Override
    public synchronized void init(ProcessingEnvironment env) {
        super.init(env);
        mFiler = env.getFiler();
        mMessager = env.getMessager();
        mTypes = env.getTypeUtils();
        mElements = env.getElementUtils();
    }

    @Override
    public boolean process(Set<? extends TypeElement> annoations, RoundEnvironment roundEnv) {
        Set<? extends Element> bindViewElements = roundEnv.getElementsAnnotatedWith(ARABindLayout.class);
        if (isTransformed) return false;
        TypeSpec.Builder adapterClass = TypeSpec.classBuilder(araName)
                .addModifiers(Modifier.PUBLIC)
                .addField(FieldSpec.builder(ClassName.get("android.app", "Activity"), "activity").addModifiers(Modifier.PRIVATE).initializer("null").build())
                .addField(FieldSpec.builder(ClassName.get("android.content", "Context"), "context").addModifiers(Modifier.PRIVATE).build())
                .addField(FieldSpec.builder(ParameterizedTypeName.get(ClassName.get("java.util", "ArrayList"), ClassName.get("liyin.party.skyrecycleradapter", "AutoDataBean")), "dataList")
                        .initializer("new ArrayList<>()").addModifiers(Modifier.PRIVATE)
                        .build())
                .superclass(ParameterizedTypeName.get(ClassName.get("android.support.v7.widget.RecyclerView", "Adapter"), ClassName.get("android.support.v7.widget.RecyclerView", "ViewHolder")));
        TypeSpec layoutIDBean = TypeSpec.classBuilder("LayoutIDBean")
                .addField(FieldSpec.builder(int.class, "layout").build())
                .addField(FieldSpec.builder(String.class, "viewHolder").build())
                .addMethod(MethodSpec.constructorBuilder()
                        .addParameter(int.class, "layout")
                        .addParameter(String.class, "viewHolder")
                        .addCode(CodeBlock.builder()
                                .addStatement("this.layout = layout")
                                .addStatement("this.viewHolder = viewHolder")
                                .build())
                        .build()).build();
        adapterClass.addType(layoutIDBean);
        MethodSpec constructorOneBuilder = MethodSpec.constructorBuilder()
                .addParameter(ParameterSpec.builder(ClassName.get("android.content", "Context"), "context").build())
                .addCode(CodeBlock.builder().addStatement("this.context = context").addStatement("initLayoutID()").build())
                .addModifiers(Modifier.PUBLIC)
                .build();
        MethodSpec constructorTwoBuilder = MethodSpec.constructorBuilder()
                .addParameter(ParameterSpec.builder(ClassName.get("android.app", "Activity"), "activity").build())
                .addCode(CodeBlock.builder().addStatement("this.context = activity").addStatement("this.activity = activity").addStatement("initLayoutID()").build())
                .addModifiers(Modifier.PUBLIC)
                .build();
        adapterClass.addMethod(constructorOneBuilder).addMethod(constructorTwoBuilder);
        CodeBlock.Builder onCreateViewHolderCode = CodeBlock.builder()
                .addStatement("$T mInflater = LayoutInflater.from(context)", ClassName.get("android.view", "LayoutInflater"))
                .beginControlFlow("if (viewType < 0)")
                .addStatement("return new GeneralViewHolder(mInflater.inflate(EmptyDataBean.empty_layout.get(viewType), parent,false))")
                .endControlFlow();
        MethodSpec.Builder onCreateViewHolderBuilder = MethodSpec.methodBuilder("onCreateViewHolder")
                .addModifiers(Modifier.PUBLIC)
                .addAnnotation(Override.class)
                .returns(ClassName.get("android.support.v7.widget.RecyclerView", "ViewHolder"))
                .addParameter(ParameterSpec.builder(ClassName.get("android.view", "ViewGroup"), "parent").build())
                .addParameter(int.class, "viewType");
        MethodSpec.Builder getItemCountBuilder = MethodSpec.methodBuilder("getItemCount")
                .addModifiers(Modifier.PUBLIC)
                .addStatement("return dataList.size()")
                .returns(int.class);
        CodeBlock.Builder onBindViewHolderCode = CodeBlock.builder()
                .addStatement("AutoDataBean bean = dataList.get(position)")
                .addStatement("if (bean instanceof EmptyDataBean) return");
        MethodSpec.Builder onBindViewHolderBuilder = MethodSpec.methodBuilder("onBindViewHolder")
                .addModifiers(Modifier.PUBLIC)
                .returns(void.class)
                .addParameter(ParameterSpec.builder(ClassName.get("android.support.v7.widget.RecyclerView", "ViewHolder"), "holder").build())
                .addParameter(int.class, "position");
        MethodSpec.Builder getItemViewTypeBuilder = MethodSpec.methodBuilder("getItemViewType")
                .addModifiers(Modifier.PUBLIC)
                .returns(int.class)
                .addParameter(int.class, "position")
                .addCode(CodeBlock.builder()
                        .addStatement("AutoDataBean bean = dataList.get(position)")
                        .addStatement("if (bean instanceof $T) return (($T)bean).layout_type", ClassName.get("liyin.party.skyrecycleradapter", "EmptyDataBean"), ClassName.get("liyin.party.skyrecycleradapter", "EmptyDataBean"))
                        .addStatement("return dataLayout.get(bean.getClass())")
                        .build());
        MethodSpec.Builder initLayoutIDBuilder = MethodSpec.methodBuilder("initLayoutID").addModifiers(Modifier.PRIVATE).returns(void.class);
        FieldSpec.Builder dataLayout = FieldSpec.builder(
                ParameterizedTypeName.get(ClassName.get("java.util", "HashMap"), ParameterizedTypeName.get(ClassName.get("java.lang", "Class"), WildcardTypeName.subtypeOf(TypeVariableName.get("AutoDataBean"))), ClassName.bestGuess(Integer.class.getCanonicalName())), "dataLayout"
        ).addModifiers(Modifier.PRIVATE).initializer("new HashMap<>()");
        TypeSpec generalViewHolder = TypeSpec.classBuilder("GeneralViewHolder")
                .addModifiers(Modifier.PROTECTED)
                .superclass(ClassName.get("android.support.v7.widget.RecyclerView", "ViewHolder"))
                .addMethod(MethodSpec.constructorBuilder().addParameter(ClassName.get("android.view", "View"), "itemView").addStatement("super(itemView)").build())
                .build();
        adapterClass.addType(generalViewHolder);
        boolean isFirst = true;
        for (Element bindViewElement : bindViewElements) {
            isTransformed = true;
            if (!bindViewElement.getModifiers().contains(Modifier.PUBLIC)) {
                mMessager.printMessage(Diagnostic.Kind.ERROR, "Only support PUBLIC Modifier for your AutoDataBean!");
            }
            int layoutId = nextLayoutID++;
            ARABindLayout bindView = bindViewElement.getAnnotation(ARABindLayout.class);
            List<? extends Element> elements = bindViewElement.getEnclosedElements();
            TypeSpec subClass = generateSubClass(layoutId, bindViewElement, elements, onBindViewHolderCode, isFirst);
            initLayoutIDBuilder.addStatement("dataLayout.put($L.class, $L)", bindViewElement.asType(), layoutId);
            adapterClass.addType(subClass);
            if (isFirst) {
                isFirst = false;
                onCreateViewHolderCode.beginControlFlow("if (viewType == $L)", layoutId)
                        .addStatement("return new $N(mInflater.inflate($L, parent, false))", subClass, bindView.value());
            } else {
                onCreateViewHolderCode.nextControlFlow("else if (viewType == $L)", layoutId)
                        .addStatement("return new $N(mInflater.inflate($L, parent, false))", subClass, bindView.value());
            }
        }
        onBindViewHolderCode.endControlFlow();
        onCreateViewHolderCode.endControlFlow().addStatement("return null");
        adapterClass.addField(dataLayout.build());
        onCreateViewHolderBuilder.addCode(onCreateViewHolderCode.build());
        adapterClass.addMethod(onCreateViewHolderBuilder.build());
        adapterClass.addMethod(getItemCountBuilder.build());
        onBindViewHolderBuilder.addCode(onBindViewHolderCode.build());
        adapterClass.addMethod(onBindViewHolderBuilder.build());
        adapterClass.addMethod(getItemViewTypeBuilder.build());
        adapterClass.addMethod(initLayoutIDBuilder.build());

        adapterClass.addMethod(MethodSpec.methodBuilder("addData")
                .addParameter(ParameterizedTypeName.get(ClassName.get("java.util", "List"), WildcardTypeName.subtypeOf(ClassName.get("liyin.party.skyrecycleradapter", "AutoDataBean"))), "beanList")
                .addModifiers(Modifier.PUBLIC)
                .addCode(CodeBlock.builder()
                        .beginControlFlow("if (this.activity == null)")
                        .addStatement("dataList.addAll(beanList)")
                        .nextControlFlow("else")
                        .addStatement("$T<$T> flatbeanList = new $T<>()", ClassName.get(ArrayList.class), ClassName.get("liyin.party.skyrecycleradapter", "AutoDataBean"), ClassName.get(ArrayList.class))
                        .beginControlFlow("for ($T autoDataBean : beanList)", ClassName.get("liyin.party.skyrecycleradapter", "AutoDataBean"))
                        .addStatement("autoDataBean.activity = this.activity")
                        .addStatement("flatbeanList.add(autoDataBean)")
                        .endControlFlow()
                        .addStatement("dataList.addAll(flatbeanList)")
                        .endControlFlow()
                        .addStatement("notifyDataSetChanged()")
                        .build())
                .build());
        adapterClass.addMethod(MethodSpec.methodBuilder("addData")
                .addParameter(ArrayTypeName.of(ClassName.get("liyin.party.skyrecycleradapter", "AutoDataBean")), "bean")
                .varargs(true)
                .addModifiers(Modifier.PUBLIC)
                .addStatement("addData($T.asList(bean))", ClassName.get("java.util", "Arrays"))
                .build());
        adapterClass.addMethod(MethodSpec.methodBuilder("remove")
                .addParameter(int.class, "position")
                .addModifiers(Modifier.PUBLIC)
                .addStatement("dataList.remove(position)")
                .addStatement("notifyDataSetChanged()")
                .build());
        adapterClass.addMethod(MethodSpec.methodBuilder("clear")
                .addModifiers(Modifier.PUBLIC)
                .addStatement("dataList.clear()")
                .addStatement("notifyDataSetChanged()")
                .build());
        adapterClass.addMethod(MethodSpec.methodBuilder("getItemList")
                .addModifiers(Modifier.PUBLIC)
                .returns(ParameterizedTypeName.get(ClassName.get(ArrayList.class), ClassName.get("liyin.party.skyrecycleradapter", "AutoDataBean")))
                .addStatement("return dataList")
                .build());

        JavaFile javaFile = JavaFile.builder(packageName, adapterClass.build()).build();
        try {
            /*if (!layoutBean.isEmpty())*/
            javaFile.writeTo(mFiler);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    private TypeSpec generateSubClass(int layoutId, Element viewElement, List<? extends Element> elements, CodeBlock.Builder onBindViewHolderCode, boolean isFirst) {
        String name = "ARA_" + layoutId + "_" + viewElement.getSimpleName().toString() + "_ViewHolder";
        TypeSpec.Builder subClass = TypeSpec.classBuilder(name)
                .addModifiers(Modifier.PROTECTED)
                .superclass(ClassName.get("android.support.v7.widget.RecyclerView", "ViewHolder"));
        CodeBlock.Builder constructorCode = CodeBlock.builder();
        MethodSpec.Builder constructor = MethodSpec.constructorBuilder().addParameter(ClassName.get("android.view", "View"), "itemView");
        constructorCode.addStatement("super(itemView)");
        if (isFirst) {
            onBindViewHolderCode.beginControlFlow("if (holder instanceof $L)", name);
        } else {
            onBindViewHolderCode.nextControlFlow("else if (holder instanceof $L)", name);
        }
        for (Element element : elements) {
            ARABind ara = element.getAnnotation(ARABind.class);
            if (ara != null) {
                String qualifiedSuperClassName;
                try {
                    Class<?> clazz = ara.view_type();
                    qualifiedSuperClassName = clazz.getCanonicalName();
                } catch (MirroredTypeException mte) {
                    DeclaredType classTypeMirror = (DeclaredType) mte.getTypeMirror();
                    TypeElement classTypeElement = (TypeElement) classTypeMirror.asElement();
                    qualifiedSuperClassName = classTypeElement.getQualifiedName().toString();
                }
                ClassName cName = ClassName.bestGuess(qualifiedSuperClassName);
                String viewFullName = "view_" + ara.view_id() + "_" + ara.view_method();
                subClass.addField(FieldSpec.builder(cName, viewFullName).build());
                constructorCode.addStatement("$L = ($T)itemView.findViewById($L)", viewFullName, cName, ara.view_id());
                if (!element.getModifiers().contains(Modifier.PUBLIC)) {
                    mMessager.printMessage(Diagnostic.Kind.ERROR, "Only support PUBLIC Modifier");
                }
                try {
                    if (mTypes.isSubtype(element.asType(), mTypes.getArrayType(mElements.getTypeElement("java.lang.Object").asType()))) {
                        onBindViewHolderCode.addStatement("$T typedBean = ($T)bean", viewElement, viewElement);
                        ArrayList<String> arr = new ArrayList<>();
                        try {
                            ara.view_param();
                        } catch (MirroredTypesException mte) {
                            List<DeclaredType> classTypeMirrors = (List<DeclaredType>) mte.getTypeMirrors();
                            for (DeclaredType classTypeMirror : classTypeMirrors) {
                                TypeElement classTypeElement = (TypeElement) classTypeMirror.asElement();
                                qualifiedSuperClassName = classTypeElement.getQualifiedName().toString();
                                arr.add(qualifiedSuperClassName);
                            }
                        }
                        ArrayList<String> resultArray = new ArrayList<>();
                        for (int i = 0; i < arr.size(); i++) {
                            String t = "(" + arr.get(i) + ")typedBean." + element.getSimpleName() + "[" + i + "]";
                            resultArray.add(t);
                        }
                        String result = StringUtils.join(resultArray, ",");
                        onBindViewHolderCode.addStatement("(($L) holder).$L.$L($L)", name, viewFullName, ara.view_method(), result);
                    } else {
                        onBindViewHolderCode.addStatement("(($L) holder).$L.$L((($T)bean).$L)", name, viewFullName, ara.view_method(), viewElement, element.getSimpleName());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        onBindViewHolderCode.addStatement("return");
        constructor.addCode(constructorCode.build());
        subClass.addMethod(constructor.build());
        return subClass.build();
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        Set<String> annotations = new LinkedHashSet<>();
        annotations.add(ARABindLayout.class.getCanonicalName());
        return annotations;
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }

}