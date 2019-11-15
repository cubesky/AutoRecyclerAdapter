package liyin.party.skyrecycleradapter;


import android.content.Context;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class SmartRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public SmartRecyclerAdapter(Context context) {
        throw new RuntimeException("Stub! You need annotation processor to enable SmartRecyclerAdapter!");
    }

    public SmartRecyclerAdapter(AppCompatActivity activity) {
        throw new RuntimeException("Stub! You need annotation processor to enable SmartRecyclerAdapter!");
    }

    public AutoBeanWithType getItemWithType(int position) {
        throw new RuntimeException("Stub! You need annotation processor to enable SmartRecyclerAdapter!");
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        throw new RuntimeException("Stub! You need annotation processor to enable SmartRecyclerAdapter!");
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        throw new RuntimeException("Stub! You need annotation processor to enable SmartRecyclerAdapter!");
    }

    @Override
    public int getItemViewType(int position) {
        throw new RuntimeException("Stub! You need annotation processor to enable SmartRecyclerAdapter!");
    }

    @Override
    public int getItemCount() {
        throw new RuntimeException("Stub! You need annotation processor to enable SmartRecyclerAdapter!");
    }


    public void addData(AutoDataBean... beans) {
        throw new RuntimeException("Stub! You need annotation processor to enable SmartRecyclerAdapter!");
    }

    @SuppressWarnings("WeakerAccess")
    public void addData(List<? extends AutoDataBean> beanList) {
        throw new RuntimeException("Stub! You need annotation processor to enable SmartRecyclerAdapter!");
    }

    public void remove(int position) {
        throw new RuntimeException("Stub! You need annotation processor to enable SmartRecyclerAdapter!");
    }

    public void clear() {
        throw new RuntimeException("Stub! You need annotation processor to enable SmartRecyclerAdapter!");
    }

    public ArrayList<AutoDataBean> getItemList() {
        throw new RuntimeException("Stub! You need annotation processor to enable SmartRecyclerAdapter!");
    }

    public enum SmartLayoutEnum {
        ;

        private final int value;

        SmartLayoutEnum(final int layoutType) {
            this.value = layoutType;
        }

        public static SmartLayoutEnum fromLayoutTypeInt(int layoutId) {
            throw new RuntimeException("Stub! You need annotation processor to enable SmartRecyclerAdapter!");
        }
    }

    public class AutoBeanWithType {
        WeakReference<AutoDataBean> bean;

        SmartLayoutEnum type;

        private AutoBeanWithType(WeakReference<AutoDataBean> bean, SmartLayoutEnum type) {
            this.bean = bean;
            this.type = type;
        }

        public SmartLayoutEnum getType() {
            return this.type;
        }

        public AutoDataBean getBean() {
            return this.bean.get();
        }
    }
}