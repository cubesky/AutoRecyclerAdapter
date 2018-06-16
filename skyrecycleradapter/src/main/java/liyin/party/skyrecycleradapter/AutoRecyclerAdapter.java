package liyin.party.skyrecycleradapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class AutoRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private Activity activity = null;
    public AutoRecyclerAdapter(Context context) {
        this.context = context;
    }
    public AutoRecyclerAdapter(Activity activity) {
        this.activity = activity;
        this.context = activity;
    }
    private ArrayList<AutoDataBean> dataList = new ArrayList<>();
    private HashMap<Class<? extends AutoDataBean>, IDLayoutBean> dataViewMap = new HashMap<>();
    private ArrayList<Class<? extends AutoDataBean>> dataViewIDList = new ArrayList<>();


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater mInflater = LayoutInflater.from(context);
        if (viewType < 0) return new GeneralViewHolder(mInflater.inflate(EmptyDataBean.empty_layout.get(viewType), parent,false));
        Class beanClass = dataViewIDList.get(viewType);
        View v = mInflater.inflate(dataViewMap.get(beanClass).getLayout(), parent, false);
        return new GeneralViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        AutoDataBean bean = dataList.get(position);
        if (bean instanceof EmptyDataBean) return;
        Field[] fields = bean.getClass().getDeclaredFields();
        for (Field field : fields) {
            AutoBind annotation = field.getAnnotation(AutoBind.class);
            if (annotation == null) continue;
            try {
                boolean fieldAccessible = field.isAccessible();
                field.setAccessible(true);
                Object obj = field.get(bean); //数据本体
                field.setAccessible(fieldAccessible);
                View v = holder.itemView.findViewById(context.getResources().getIdentifier(annotation.view_id(), "id", context.getPackageName())); //控件本体
                Method viewMethod;
                try {
                    viewMethod = v.getClass().getMethod(annotation.view_method(), annotation.view_param());
                } catch (NoSuchMethodException e) {
                    viewMethod = v.getClass().getDeclaredMethod(annotation.view_method(), annotation.view_param());
                }
                boolean methodAccessible = viewMethod.isAccessible();
                viewMethod.setAccessible(true);
                if(obj.getClass().isArray()) {
                    ArrayList<Object> unpackArray = new ArrayList<>();
                    int length = Array.getLength(obj);
                    for (int i = 0; i < length; i ++) {
                        Object arrayElement = Array.get(obj, i);
                        if (!"".equals(annotation.wrapTo()) && arrayElement.getClass() == String.class) {
                            arrayElement = context.getResources().getIdentifier(obj.toString(), annotation.wrapTo(), context.getPackageName());
                        }
                        unpackArray.add(arrayElement);
                    }
                    viewMethod.invoke(v, unpackArray.toArray());
                } else {
                    if ("".equals(annotation.wrapTo())) {
                        viewMethod.invoke(v, obj);
                    } else {
                        viewMethod.invoke(v, context.getResources().getIdentifier(obj.toString(), annotation.wrapTo(), context.getPackageName()));
                    }
                }
                viewMethod.setAccessible(methodAccessible);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public int getItemViewType(int position) {
        AutoDataBean bean = dataList.get(position);
        if (bean instanceof EmptyDataBean) return ((EmptyDataBean)bean).layout_type;
        return dataViewMap.get(bean.getClass()).getId();
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    private class IDLayoutBean {
        private int id;
        private int layout;
        IDLayoutBean(int id, int layout) {
            this.id = id;
            this.layout = layout;
        }
        public int getId() {
            return id;
        }
        public int getLayout() {
            return layout;
        }
    }

    protected class GeneralViewHolder extends RecyclerView.ViewHolder {
        GeneralViewHolder(View itemView) {
            super(itemView);
        }
    }

    public void bindView(Class<? extends AutoDataBean> bean, int layout_id) {
        IDLayoutBean idLayoutBean = new IDLayoutBean(dataViewIDList.size(), layout_id);
        dataViewMap.put(bean, idLayoutBean);
        dataViewIDList.add(bean);
    }

    public void addData(AutoDataBean ... beans) {
        addData(Arrays.asList(beans));
    }

    @SuppressWarnings("WeakerAccess")
    public void addData(List<? extends AutoDataBean> beanList) {
        if (this.activity == null){
            dataList.addAll(beanList);
        } else {
            ArrayList<AutoDataBean> flatbeanList = new ArrayList<>();
            for (AutoDataBean autoDataBean : beanList) {
                autoDataBean.activity = this.activity;
                flatbeanList.add(autoDataBean);
            }
            dataList.addAll(flatbeanList);
        }
        notifyDataSetChanged();
    }

    public void remove(int position) {
        dataList.remove(position);
        notifyDataSetChanged();
    }

    public void clear(){
        dataList.clear();
        notifyDataSetChanged();
    }

    public ArrayList<AutoDataBean> getItemList() {
        return dataList;
    }

}
