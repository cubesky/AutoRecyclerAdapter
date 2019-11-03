package androidx.recyclerview.widget;

import android.view.ViewGroup;

public class RecyclerView extends ViewGroup {
    public abstract static class ViewHolder {

    }

    public abstract static class Adapter<VH extends ViewHolder> {
        public abstract VH onCreateViewHolder(ViewGroup parent, int viewType);

        public abstract void onBindViewHolder(VH holder, int position);

        public abstract int getItemViewType(int position);

        public abstract int getItemCount();
    }
}
