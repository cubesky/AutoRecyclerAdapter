package liyin.party.skyrecycleradapter;

import android.util.SparseArray;
import android.util.SparseIntArray;

/**
 * AutoDataBean for View which doesn't contain any dynamic data
 */
public class EmptyDataBean extends AutoDataBean{
    private static int layout_next = -1;
    protected int layout_type;
    protected static SparseIntArray empty_layout = new SparseIntArray(); //<Type,Layout>
    private static SparseArray<EmptyDataBean> empty_layout_reverse = new SparseArray<>(); //<Layout,Type>

    private EmptyDataBean(int layout_type) {
        this.layout_type = layout_type;
    }

    /**
     * Create an EmptyDataBean from LayoutID
     *
     * @param layout_id ID from R.layout
     * @return EmptyDataBean instance
     */
    public static EmptyDataBean getEmptyLayout(int layout_id) {
        EmptyDataBean hasEmptyDataBean = empty_layout_reverse.get(layout_id, null);
        if (hasEmptyDataBean != null) {
            return hasEmptyDataBean;
        }
        EmptyDataBean emptyDataBean = new EmptyDataBean(layout_next);
        empty_layout.append(layout_next, layout_id);
        empty_layout_reverse.append(layout_id, emptyDataBean);
        EmptyDataBean.layout_next = EmptyDataBean.layout_next - 1;
        return emptyDataBean;
    }
}
