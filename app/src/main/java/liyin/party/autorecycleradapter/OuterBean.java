package liyin.party.autorecycleradapter;

import android.widget.TextView;

import liyin.party.skyrecycleradapter.AutoDataBean;
import party.liyin.aralib.ARABind;
import party.liyin.aralib.ARABindLayout;

@ARABindLayout(R.layout.layout_one)
public class OuterBean extends AutoDataBean {
    @ARABind(view_id = R.id.textView, view_type = TextView.class, view_method = "setText")
    public String data;
    @ARABind(view_id = R.id.textView, view_type = TextView.class, view_method = "setTextSize", view_param = {Integer.class, Float.class})
    public Object[] size;

    OuterBean(String data, int unit, float size) {
        this.data = data;
        this.size = new Object[]{unit, size};
    }
}
