package liyin.party.skyrecycleradapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class SmartRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public SmartRecyclerAdapter(Context context) {
        throw new RuntimeException("Stub! You need annotation processor to enable SmartRecyclerAdapter!");
    }

    public SmartRecyclerAdapter(Activity activity) {
        throw new RuntimeException("Stub! You need annotation processor to enable SmartRecyclerAdapter!");
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        throw new RuntimeException("Stub! You need annotation processor to enable SmartRecyclerAdapter!");
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
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

}
