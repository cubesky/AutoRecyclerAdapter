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

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
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
import party.liyin.aralib.ARALink;

@AutoService(Processor.class)
public class ARAProcessor extends AbstractProcessor {
    boolean isTransformed = false; //If Transformed is fired
    private Filer mFiler; //Java File Writer
    private Messager mMessager; //Message for annotation processor
    private Types mTypes;
    private Elements mElements;
    private int nextLayoutID = 0; //Layout ID for SmartRecyclerAdapter
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

    /**
     * Join String with comma
     *
     * @param input List of String
     * @return String joined with comma
     */
    private static String join(List<String> input) {
        if (input == null || input.size() <= 0) return "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.size(); i++) {
            sb.append(input.get(i));
            // if not the last item
            if (i != input.size() - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
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
                .superclass(ParameterizedTypeName.get(ClassName.get("androidx.recyclerview.widget.RecyclerView", "Adapter"), ClassName.get("androidx.recyclerview.widget.RecyclerView", "ViewHolder")))
                .addJavadoc("SmartRecyclerAdapter (Generated)\n");
        TypeSpec.Builder layoutTypeEnum = TypeSpec.enumBuilder("SmartLayoutEnum")
                .addModifiers(Modifier.PUBLIC)
                .addField(FieldSpec.builder(int.class, "value", Modifier.FINAL, Modifier.PRIVATE).build())
                .addMethod(MethodSpec.constructorBuilder()
                        .addParameter(int.class, "layoutType", Modifier.FINAL)
                        .addStatement("this.value = layoutType")
                        .addJavadoc("Layout Enum to Integer ID constructor\n")
                        .build())
                .addJavadoc("Enum for Layout ID\n");
        TypeSpec autoBeanWithType = TypeSpec.classBuilder("AutoBeanWithType")
                .addModifiers(Modifier.PUBLIC)
                .addField(FieldSpec.builder(ParameterizedTypeName.get(ClassName.get(WeakReference.class), ClassName.get("liyin.party.skyrecycleradapter", "AutoDataBean")), "bean").build())
                .addField(FieldSpec.builder(ClassName.get(packageName, araName).nestedClass("SmartLayoutEnum"), "type").build())
                .addMethod(MethodSpec.constructorBuilder()
                        .addModifiers(Modifier.PRIVATE)
                        .addParameter(ParameterizedTypeName.get(ClassName.get(WeakReference.class), ClassName.get("liyin.party.skyrecycleradapter", "AutoDataBean")), "bean")
                        .addParameter(ClassName.get(packageName, araName).nestedClass("SmartLayoutEnum"), "type")
                        .addStatement("this.bean = bean")
                        .addStatement("this.type = type")
                        .addJavadoc("Create Bean-Type Triple\n")
                        .addJavadoc("@param bean WeakReference AutoDataBean\n")
                        .addJavadoc("@param type TypeEnum\n")
                        .build())
                .addMethod(MethodSpec.methodBuilder("getType")
                        .addModifiers(Modifier.PUBLIC)
                        .returns(ClassName.get(packageName, araName).nestedClass("SmartLayoutEnum"))
                        .addStatement("return this.type")
                        .addJavadoc("Return AutoDataBean type in Enum\n")
                        .addJavadoc("@return Layout Enum Type\n")
                        .build())
                .addMethod(MethodSpec.methodBuilder("getBean")
                        .addModifiers(Modifier.PUBLIC)
                        .returns(ClassName.get("liyin.party.skyrecycleradapter", "AutoDataBean"))
                        .addStatement("return this.bean.get()")
                        .addJavadoc("Return AutoDataBean\n")
                        .addJavadoc("@return AutoDataBean\n")
                        .build())
                .build();
        MethodSpec.Builder layoutTypeEnumFromLayoutTypeInt = MethodSpec.methodBuilder("fromLayoutTypeInt")
                .addParameter(ParameterSpec.builder(int.class, "layoutId").build())
                .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
                .addJavadoc("Return Layout Type Enum from LayoutView ID in SmartRecyclerAdapter\n")
                .addJavadoc("@param layoutId LayoutID Integer\n")
                .addJavadoc("@return SmartLayoutEnum\n")
                .beginControlFlow("switch (layoutId)");
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
                .addJavadoc("Create SmartRecyclerAdapter with context. This method can not active activity variable in AutoDataBean superclass.\n")
                .addJavadoc("@param context Context\n")
                .build();
        MethodSpec constructorTwoBuilder = MethodSpec.constructorBuilder()
                .addParameter(ParameterSpec.builder(ClassName.get("android.app", "Activity"), "activity").build())
                .addCode(CodeBlock.builder().addStatement("this.context = activity").addStatement("this.activity = activity").addStatement("initLayoutID()").build())
                .addModifiers(Modifier.PUBLIC)
                .addJavadoc("Create SmartRecyclerAdapter with context.\n")
                .addJavadoc("@param activity Activity\n")
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
                .returns(ClassName.get("androidx.recyclerview.widget.RecyclerView", "ViewHolder"))
                .addParameter(ParameterSpec.builder(ClassName.get("android.view", "ViewGroup"), "parent").build())
                .addParameter(int.class, "viewType");
        MethodSpec.Builder getItemCountBuilder = MethodSpec.methodBuilder("getItemCount")
                .addModifiers(Modifier.PUBLIC)
                .addStatement("return dataList.size()")
                .addJavadoc("Return the count of data\n")
                .addJavadoc("@return Count of Data in SmartRecyclerAdapter\n")
                .returns(int.class);
        CodeBlock.Builder onBindViewHolderCode = CodeBlock.builder()
                .addStatement("AutoDataBean bean = dataList.get(position)")
                .addStatement("if (bean instanceof EmptyDataBean) return");
        MethodSpec.Builder onBindViewHolderBuilder = MethodSpec.methodBuilder("onBindViewHolder")
                .addModifiers(Modifier.PUBLIC)
                .returns(void.class)
                .addParameter(ParameterSpec.builder(ClassName.get("androidx.recyclerview.widget.RecyclerView", "ViewHolder"), "holder").build())
                .addParameter(int.class, "position");
        MethodSpec.Builder getItemViewTypeBuilder = MethodSpec.methodBuilder("getItemViewType")
                .addModifiers(Modifier.PUBLIC)
                .returns(int.class)
                .addParameter(int.class, "position")
                .addCode(CodeBlock.builder()
                        .addStatement("AutoDataBean bean = dataList.get(position)")
                        .addStatement("if (bean instanceof $T) return (($T)bean).layout_type", ClassName.get("liyin.party.skyrecycleradapter", "EmptyDataBean"), ClassName.get("liyin.party.skyrecycleradapter", "EmptyDataBean"))
                        .addStatement("return dataLayout.get(bean.getClass())")
                        .build())
                .addJavadoc("Get ItemViewType from position\n")
                .addJavadoc("@param position position of data\n")
                .addJavadoc("@return ViewType ID\n");
        MethodSpec.Builder initLayoutIDBuilder = MethodSpec.methodBuilder("initLayoutID").addModifiers(Modifier.PRIVATE).returns(void.class);
        FieldSpec.Builder dataLayout = FieldSpec.builder(
                ParameterizedTypeName.get(ClassName.get("java.util", "HashMap"), ParameterizedTypeName.get(ClassName.get("java.lang", "Class"), WildcardTypeName.subtypeOf(TypeVariableName.get("AutoDataBean"))), ClassName.bestGuess(Integer.class.getCanonicalName())), "dataLayout"
        ).addModifiers(Modifier.PRIVATE).initializer("new HashMap<>()");
        TypeSpec generalViewHolder = TypeSpec.classBuilder("GeneralViewHolder")
                .addModifiers(Modifier.PROTECTED)
                .superclass(ClassName.get("androidx.recyclerview.widget.RecyclerView", "ViewHolder"))
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
            layoutTypeEnum.addEnumConstant(bindViewElement.getSimpleName().toString(), TypeSpec.anonymousClassBuilder("$L", layoutId).build());
            layoutTypeEnumFromLayoutTypeInt.addCode("case $L:\n", layoutId).addStatement("$>return $L.$L$<", "SmartLayoutEnum", bindViewElement.getSimpleName().toString());
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
                .addJavadoc("Add Data using AutoDataBean child class\n")
                .addJavadoc("@param beanList AutoDataBean child class with ARABindLayout\n")
                .build());
        adapterClass.addMethod(MethodSpec.methodBuilder("addData")
                .addParameter(ArrayTypeName.of(ClassName.get("liyin.party.skyrecycleradapter", "AutoDataBean")), "bean")
                .varargs(true)
                .addModifiers(Modifier.PUBLIC)
                .addStatement("addData($T.asList(bean))", ClassName.get("java.util", "Arrays"))
                .addJavadoc("Add Data using AutoDataBean child class\n")
                .addJavadoc("@param bean AutoDataBean child class with ARABindLayout\n")
                .build());
        adapterClass.addMethod(MethodSpec.methodBuilder("remove")
                .addParameter(int.class, "position")
                .addModifiers(Modifier.PUBLIC)
                .addStatement("dataList.remove(position)")
                .addStatement("notifyDataSetChanged()")
                .addJavadoc("Remove data from SmartRecyclerAdapter\n")
                .addJavadoc("@param position position of data\n")
                .build());
        adapterClass.addMethod(MethodSpec.methodBuilder("clear")
                .addModifiers(Modifier.PUBLIC)
                .addStatement("dataList.clear()")
                .addStatement("notifyDataSetChanged()")
                .addJavadoc("Clear SmartRecyclerAdapter\n")
                .build());
        adapterClass.addMethod(MethodSpec.methodBuilder("getItemWithType")
                .addParameter(int.class, "position")
                .addModifiers(Modifier.PUBLIC)
                .returns(ClassName.bestGuess(autoBeanWithType.name))
                .addStatement("return new $L(new $T($L), $L)", ClassName.bestGuess(autoBeanWithType.name), WeakReference.class, "dataList.get(position)", "SmartLayoutEnum.fromLayoutTypeInt(getItemViewType(position))")
                .addJavadoc("Return AutoDataBean and its LayoutEnum from position\n")
                .addJavadoc("@param position position of data\n")
                .addJavadoc("@return AutoBeanWithType\n")
                .build());
        adapterClass.addMethod(MethodSpec.methodBuilder("getItemList")
                .addModifiers(Modifier.PUBLIC)
                .returns(ParameterizedTypeName.get(ClassName.get(ArrayList.class), ClassName.get("liyin.party.skyrecycleradapter", "AutoDataBean")))
                .addStatement("return dataList")
                .addJavadoc("Get raw data list store in SmartRecyclerAdapter. If you modify this list, don't forget to class notifyDataSetChanged()\n")
                .addJavadoc("@return ArrayList of data\n")
                .build());

        layoutTypeEnum.addMethod(layoutTypeEnumFromLayoutTypeInt.addCode("default:\n").addStatement("$>return null$<").endControlFlow().returns(ClassName.get(packageName, araName).nestedClass("SmartLayoutEnum")).build());
        adapterClass.addType(layoutTypeEnum.build());
        adapterClass.addType(autoBeanWithType);

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
        HashSet<Integer> hasARAView = new HashSet<>();
        String name = "ARA_" + layoutId + "_" + viewElement.getSimpleName().toString() + "_ViewHolder";
        TypeSpec.Builder subClass = TypeSpec.classBuilder(name)
                .addModifiers(Modifier.PROTECTED)
                .superclass(ClassName.get("androidx.recyclerview.widget.RecyclerView", "ViewHolder"));
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
                hasARAView.add(ara.view_id());
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
                            @SuppressWarnings("unchecked")
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

                        String result = join(resultArray);
                        onBindViewHolderCode.addStatement("(($L) holder).$L.$L($L)", name, viewFullName, ara.view_method(), result);
                    } else {
                        onBindViewHolderCode.addStatement("(($L) holder).$L.$L((($T)bean).$L)", name, viewFullName, ara.view_method(), viewElement, element.getSimpleName());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

            ARALink link = element.getAnnotation(ARALink.class);
            if (link != null) {
                ClassName cName = ClassName.bestGuess(element.asType().toString());
                String viewFullName = "view_" + link.view_id();
                subClass.addField(FieldSpec.builder(cName, viewFullName).build());
                constructorCode
                        .addStatement("$L = ($T)itemView.findViewById($L)", viewFullName, cName, link.view_id());
                if (hasARAView.contains(link.view_id())) {
                    mMessager.printMessage(Diagnostic.Kind.WARNING, "Use ARABind and ARALink on the same component isn't a good idea. ARABind will always override the same method.");
                }
                if (!element.getModifiers().contains(Modifier.PUBLIC)) {
                    mMessager.printMessage(Diagnostic.Kind.ERROR, "Only support PUBLIC Modifier");
                }
                try {
                    onBindViewHolderCode.addStatement("(($T)bean).$L = (($L) holder).$L", viewElement, element.getSimpleName(), name, viewFullName);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        onBindViewHolderCode.addStatement("bean.isInit = true");
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