package liyin.party.skyrecycleradapter;

import android.content.Context;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

public class RecyclerHelper {
    public static RecyclerView.LayoutManager getLayoutManager(Context ctx, RecyclerViewLayoutMangerEnum recyclerViewLayoutMangerEnum) {
        switch (recyclerViewLayoutMangerEnum) {
            case Linear_VERTICAL:
                return new LinearLayoutManager(ctx, LinearLayoutManager.VERTICAL, false);
            case Linear_HORIZONTAL:
                return new LinearLayoutManager(ctx, LinearLayoutManager.HORIZONTAL, false);
            case Linear_VERTICAL_REVERSED:
                return new LinearLayoutManager(ctx, LinearLayoutManager.VERTICAL, true);
            case Linear_HORIZONTAL_REVERSED:
                return new LinearLayoutManager(ctx, LinearLayoutManager.HORIZONTAL, true);
            case StaggeredGrid_VERTICAL_2:
                return new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
            case StaggeredGrid_VERTICAL_3:
                return new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
            case StaggeredGrid_VERTICAL_4:
                return new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL);
            case StaggeredGrid_VERTICAL_5:
                return new StaggeredGridLayoutManager(5, StaggeredGridLayoutManager.VERTICAL);
            case StaggeredGrid_VERTICAL_6:
                return new StaggeredGridLayoutManager(6, StaggeredGridLayoutManager.VERTICAL);
            case StaggeredGrid_HORIZONTAL_2:
                return new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.HORIZONTAL);
            case StaggeredGrid_HORIZONTAL_3:
                return new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.HORIZONTAL);
            case StaggeredGrid_HORIZONTAL_4:
                return new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.HORIZONTAL);
            case StaggeredGrid_HORIZONTAL_5:
                return new StaggeredGridLayoutManager(5, StaggeredGridLayoutManager.HORIZONTAL);
            case StaggeredGrid_HORIZONTAL_6:
                return new StaggeredGridLayoutManager(6, StaggeredGridLayoutManager.HORIZONTAL);
            default:
                return null;
        }
    }

    public enum RecyclerViewLayoutMangerEnum {
        Linear_VERTICAL, Linear_HORIZONTAL, Linear_VERTICAL_REVERSED, Linear_HORIZONTAL_REVERSED,
        StaggeredGrid_VERTICAL_2, StaggeredGrid_VERTICAL_3, StaggeredGrid_VERTICAL_4, StaggeredGrid_VERTICAL_5, StaggeredGrid_VERTICAL_6,
        StaggeredGrid_HORIZONTAL_2, StaggeredGrid_HORIZONTAL_3, StaggeredGrid_HORIZONTAL_4, StaggeredGrid_HORIZONTAL_5, StaggeredGrid_HORIZONTAL_6
    }
}
