package liyin.party.autorecycleradapter;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import liyin.party.skyrecycleradapter.AutoDataBean;
import liyin.party.skyrecycleradapter.EmptyDataBean;
import liyin.party.skyrecycleradapter.SmartRecyclerAdapter;
import party.liyin.aralib.ARABind;
import party.liyin.aralib.ARABindLayout;
import party.liyin.aralib.ARALink;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    SmartRecyclerAdapter autoRecyclerAdapter;

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
        autoRecyclerAdapter = new SmartRecyclerAdapter(this);
        recyclerView.setAdapter(autoRecyclerAdapter);
        autoRecyclerAdapter.addData(new OneDataBean("1T", TypedValue.COMPLEX_UNIT_PX, 30f),new TwoDataBean("2B"),new OneDataBean("3T", TypedValue.COMPLEX_UNIT_SP, 20f),
                new ThreeDataBean(R.drawable.ic_battery_charging_full_black_24dp), new TwoDataBean("4B"), new TwoDataBean("5B"), new ThreeDataBean(R.drawable.ic_assessment_black_24dp));
        autoRecyclerAdapter.addData(EmptyDataBean.getEmptyLayout(R.layout.layout_empty_one), EmptyDataBean.getEmptyLayout(R.layout.layout_empty_two), EmptyDataBean.getEmptyLayout(R.layout.layout_empty_one));
        autoRecyclerAdapter.addData(new OuterBean("1O", TypedValue.COMPLEX_UNIT_PX, 50f));

        new Thread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(5000);
                runOnUiThread(new Runnable() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void run() {
                        try {
                            SmartRecyclerAdapter.AutoBeanWithType beanWithType = autoRecyclerAdapter.getItemWithType(0);
                            if (beanWithType.getType() == SmartRecyclerAdapter.SmartLayoutEnum.OneDataBean) {
                                ((OneDataBean) beanWithType.getBean()).textView.setText("1TT");
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        }).start();
    }

    @ARABindLayout(R.layout.layout_one)
    public class OneDataBean extends AutoDataBean {
        @ARALink(view_id = R.id.textView)
        public TextView textView;
        @ARABind(view_id = R.id.textView, view_type = TextView.class, view_method = "setText")
        public String data;
        @ARABind(view_id = R.id.textView, view_type = TextView.class, view_method = "setTextSize", view_param = {Integer.class, Float.class})
        public Object[] size;
        OneDataBean(String data, int unit, float size) {
            this.data = data;
            this.size = new Object[]{unit, size};
        }
    }

    @ARABindLayout(R.layout.layout_two)
    public class TwoDataBean extends AutoDataBean {
        @ARABind(view_id = R.id.button, view_type = Button.class, view_method = "setText")
        public String data;
        @ARABind(view_id = R.id.button, view_type = Button.class, view_method = "setOnClickListener")
        public View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)activity).show(((Button)view).getText().toString());
            }
        };
        TwoDataBean(String data) {
            this.data = data;
        }
    }

    @ARABindLayout(R.layout.layout_three)
    public class ThreeDataBean extends AutoDataBean {
        @ARABind(view_id = R.id.imageView, view_type = ImageView.class, view_method = "setImageResource")
        public int id;

        ThreeDataBean(int id) {
            this.id = id;
        }
    }
}
