package liyin.party.skyrecycleradapter;


import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * <p><b>Warning: You must active annotaion processor for SmartRecyclerAdapter</b></p>
 *
 * <p><b>SmartRecyclerAdapter doesn't generate.</b></p>
 * <p>
 * SmartRecyclerAdapter (You must generate this class using annotation processor)
 */
public class SmartRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    /**
     * <p><b>Warning: You must active annotaion processor for SmartRecyclerAdapter</b></p>
     *
     * <p><b>SmartRecyclerAdapter doesn't generate.</b></p>
     *
     * Create SmartRecyclerAdapter with context. This method can not active activity variable in AutoDataBean superclass.
     * @param context Context
     */
    public SmartRecyclerAdapter(Context context) {
        throw new RuntimeException("Stub! You need annotation processor to enable SmartRecyclerAdapter!");
    }

    /**
     * <p><b>Warning: You must active annotaion processor for SmartRecyclerAdapter</b></p>
     *
     * <p><b>SmartRecyclerAdapter doesn't generate.</b></p>
     *
     * Create SmartRecyclerAdapter with context.
     * @param activity Activity
     */
    public SmartRecyclerAdapter(Activity activity) {
        throw new RuntimeException("Stub! You need annotation processor to enable SmartRecyclerAdapter!");
    }

    /**
     * <p><b>Warning: You must active annotaion processor for SmartRecyclerAdapter</b></p>
     *
     * <p><b>SmartRecyclerAdapter doesn't generate.</b></p>
     *
     * Return AutoDataBean and its LayoutEnum from position
     * @param position position of data
     * @return AutoBeanWithType
     */
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

    /**
     * <p><b>Warning: You must active annotaion processor for SmartRecyclerAdapter</b></p>
     *
     * <p><b>SmartRecyclerAdapter doesn't generate.</b></p>
     *
     * Get ItemViewType from position
     * @param position position of data
     * @return ViewType ID
     */
    @Override
    public int getItemViewType(int position) {
        throw new RuntimeException("Stub! You need annotation processor to enable SmartRecyclerAdapter!");
    }

    /**
     * <p><b>Warning: You must active annotaion processor for SmartRecyclerAdapter</b></p>
     *
     * <p><b>SmartRecyclerAdapter doesn't generate.</b></p>
     *
     * Return the count of data
     * @return Count of Data in SmartRecyclerAdapter
     */
    @Override
    public int getItemCount() {
        throw new RuntimeException("Stub! You need annotation processor to enable SmartRecyclerAdapter!");
    }

    /**
     * <p><b>Warning: You must active annotaion processor for SmartRecyclerAdapter</b></p>
     *
     * <p><b>SmartRecyclerAdapter doesn't generate.</b></p>
     * <p>
     * Add Data using AutoDataBean child class
     *
     * @param bean AutoDataBean child class with ARABindLayout
     */
    public void addData(AutoDataBean... bean) {
        throw new RuntimeException("Stub! You need annotation processor to enable SmartRecyclerAdapter!");
    }

    /**
     * <p><b>Warning: You must active annotaion processor for SmartRecyclerAdapter</b></p>
     *
     * <p><b>SmartRecyclerAdapter doesn't generate.</b></p>
     *
     * Add Data using AutoDataBean child class
     * @param beanList AutoDataBean child class with ARABindLayout
     */
    @SuppressWarnings("WeakerAccess")
    public void addData(List<? extends AutoDataBean> beanList) {
        throw new RuntimeException("Stub! You need annotation processor to enable SmartRecyclerAdapter!");
    }

    /**
     * <p><b>Warning: You must active annotaion processor for SmartRecyclerAdapter</b></p>
     *
     * <p><b>SmartRecyclerAdapter doesn't generate.</b></p>
     *
     * Remove data from SmartRecyclerAdapter
     * @param position position of data
     */
    public void remove(int position) {
        throw new RuntimeException("Stub! You need annotation processor to enable SmartRecyclerAdapter!");
    }

    /**
     * <p><b>Warning: You must active annotaion processor for SmartRecyclerAdapter</b></p>
     *
     * <p><b>SmartRecyclerAdapter doesn't generate.</b></p>
     *
     * Clear SmartRecyclerAdapter
     */
    public void clear() {
        throw new RuntimeException("Stub! You need annotation processor to enable SmartRecyclerAdapter!");
    }

    /**
     * <p><b>Warning: You must active annotaion processor for SmartRecyclerAdapter</b></p>
     *
     * <p><b>SmartRecyclerAdapter doesn't generate.</b></p>
     *
     * Get raw data list store in SmartRecyclerAdapter. If you modify this list, don't forget to class notifyDataSetChanged()
     * @return ArrayList of data
     */
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

        /**
         * <p><b>Warning: You must active annotaion processor for SmartRecyclerAdapter</b></p>
         *
         * <p><b>SmartRecyclerAdapter doesn't generate.</b></p>
         *
         * Create Bean-Type Triple
         * @param bean AutoDataBean
         * @param type TypeEnum
         */
        private AutoBeanWithType(WeakReference<AutoDataBean> bean, SmartLayoutEnum type) {
            this.bean = bean;
            this.type = type;
        }

        /**
         * <p><b>Warning: You must active annotaion processor for SmartRecyclerAdapter</b></p>
         *
         * <p><b>SmartRecyclerAdapter doesn't generate.</b></p>
         *
         * Return AutoDataBean type in Enum
         * @return Layout Enum Type
         */
        public SmartLayoutEnum getType() {
            return this.type;
        }

        /**
         * <p><b>Warning: You must active annotaion processor for SmartRecyclerAdapter</b></p>
         *
         * <p><b>SmartRecyclerAdapter doesn't generate.</b></p>
         *
         * Return AutoDataBean
         * @return AutoDataBean
         */
        public AutoDataBean getBean() {
            return this.bean.get();
        }
    }
}