package liyin.party.autorecycleradapter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import liyin.party.skyrecycleradapter.AutoDataBean;
import liyin.party.skyrecycleradapter.AutoDataBeanAnnotation;
import liyin.party.skyrecycleradapter.AutoRecyclerAdapter;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    AutoRecyclerAdapter autoRecyclerAdapter;
    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Toast.makeText(MainActivity.this, ((Button)view).getText(), Toast.LENGTH_SHORT).show();
        }
    };
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

        autoRecyclerAdapter.addData(new OneDataBean("1T"));
        autoRecyclerAdapter.addData(new TwoDataBean("2B",listener));
        autoRecyclerAdapter.addData(new OneDataBean("3T"));
        autoRecyclerAdapter.addData(new ThreeDataBean("ic_battery_charging_full_black_24dp"));
        autoRecyclerAdapter.addData(new TwoDataBean("4B",listener));
        autoRecyclerAdapter.addData(new TwoDataBean("5B",listener));
        autoRecyclerAdapter.addData(new ThreeDataBean("ic_assessment_black_24dp"));

    }

    class OneDataBean extends AutoDataBean {
        @AutoDataBeanAnnotation(view_id = "textView",view_method = "setText",view_param = CharSequence.class)
        protected String data;
        OneDataBean(String data) {
            this.data = data;
        }
    }
    class TwoDataBean extends AutoDataBean {
        @AutoDataBeanAnnotation(view_id = "button",view_method = "setText",view_param = CharSequence.class)
        protected String data;
        @AutoDataBeanAnnotation(view_id = "button",view_method = "setOnClickListener",view_param = View.OnClickListener.class)
        protected View.OnClickListener onClickListener;
        TwoDataBean(String data, View.OnClickListener onClickListener) {
            this.data = data;
            this.onClickListener = onClickListener;
        }
    }
    class ThreeDataBean extends AutoDataBean {
        @AutoDataBeanAnnotation(view_id = "imageView",view_method = "setImageResource",view_param = int.class, wrapTo = "drawable")
        protected String id;
        ThreeDataBean(String id) {
            this.id = id;
        }
    }
}
