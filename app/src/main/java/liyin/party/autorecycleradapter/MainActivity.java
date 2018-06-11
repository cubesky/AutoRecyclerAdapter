package liyin.party.autorecycleradapter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import liyin.party.skyrecycleradapter.AutoDataBean;
import liyin.party.skyrecycleradapter.AutoBind;
import liyin.party.skyrecycleradapter.AutoRecyclerAdapter;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    AutoRecyclerAdapter autoRecyclerAdapter;

    public void show(String str) {
        Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(llm);
        autoRecyclerAdapter = new AutoRecyclerAdapter(this);

        recyclerView.setAdapter(autoRecyclerAdapter);
        autoRecyclerAdapter.bindView(OneDataBean.class, R.layout.layout_one);
        autoRecyclerAdapter.bindView(TwoDataBean.class, R.layout.layout_two);
        autoRecyclerAdapter.bindView(ThreeDataBean.class, R.layout.layout_three);
        autoRecyclerAdapter.addData(new OneDataBean("1T", TypedValue.COMPLEX_UNIT_PX, 30f),new TwoDataBean("2B"),new OneDataBean("3T", TypedValue.COMPLEX_UNIT_SP, 20f),
                new ThreeDataBean("ic_battery_charging_full_black_24dp"),new TwoDataBean("4B"),new TwoDataBean("5B"),new ThreeDataBean("ic_assessment_black_24dp"));
    }
    class OneDataBean extends AutoDataBean {
        @AutoBind(view_id = "textView",view_method = "setText",view_param = CharSequence.class)
        protected String data;
        @AutoBind(view_id = "textView", view_method = "setTextSize", view_param = {int.class, float.class})
        protected Object[] size;
        OneDataBean(String data, int unit, float size) {
            this.data = data;
            this.size = new Object[]{unit, size};
        }
    }
    class TwoDataBean extends AutoDataBean {
        @AutoBind(view_id = "button",view_method = "setText",view_param = CharSequence.class)
        protected String data;
        @AutoBind(view_id = "button",view_method = "setOnClickListener",view_param = View.OnClickListener.class)
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)activity).show(((Button)view).getText().toString());
            }
        };
        TwoDataBean(String data) {
            this.data = data;
        }
    }
    class ThreeDataBean extends AutoDataBean {
        @AutoBind(view_id = "imageView",view_method = "setImageResource",view_param = int.class, wrapTo = "drawable")
        protected String id;
        ThreeDataBean(String id) {
            this.id = id;
        }
    }
}
