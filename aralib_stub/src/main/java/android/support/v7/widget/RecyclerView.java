package android.support.v7.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.accessibility.AccessibilityNodeInfoCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;


public class RecyclerView extends ViewGroup {
    public static final int HORIZONTAL = 0;
    public static final int VERTICAL = 1;
    public static final int NO_POSITION = -1;
    public static final long NO_ID = -1L;
    public static final int INVALID_TYPE = -1;
    public static final int TOUCH_SLOP_DEFAULT = 0;
    public static final int TOUCH_SLOP_PAGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_SETTLING = 2;

    public RecyclerView(Context context) {
        throw new RuntimeException("Stub!");
    }

    public RecyclerView(Context context, AttributeSet attrs) {
        throw new RuntimeException("Stub!");
    }

    public RecyclerView(Context context, AttributeSet attrs, int defStyle) {
        throw new RuntimeException("Stub!");
    }

    public RecyclerViewAccessibilityDelegate getCompatAccessibilityDelegate() {
        throw new RuntimeException("Stub!");
    }

    public void setAccessibilityDelegateCompat(RecyclerViewAccessibilityDelegate accessibilityDelegate) {
        throw new RuntimeException("Stub!");
    }

    public void setHasFixedSize(boolean hasFixedSize) {
        throw new RuntimeException("Stub!");
    }

    public boolean hasFixedSize() {
        throw new RuntimeException("Stub!");
    }

    public void setClipToPadding(boolean clipToPadding) {
        throw new RuntimeException("Stub!");
    }

    public boolean getClipToPadding() {
        throw new RuntimeException("Stub!");
    }

    public void setScrollingTouchSlop(int slopConstant) {
        throw new RuntimeException("Stub!");
    }

    public void swapAdapter(android.support.v7.widget.RecyclerView.Adapter adapter, boolean removeAndRecycleExistingViews) {
        throw new RuntimeException("Stub!");
    }

    public void setAdapter(android.support.v7.widget.RecyclerView.Adapter adapter) {
        throw new RuntimeException("Stub!");
    }

    public android.support.v7.widget.RecyclerView.Adapter getAdapter() {
        throw new RuntimeException("Stub!");
    }

    public void setRecyclerListener(android.support.v7.widget.RecyclerView.RecyclerListener listener) {
        throw new RuntimeException("Stub!");
    }

    public int getBaseline() {
        throw new RuntimeException("Stub!");
    }

    public void addOnChildAttachStateChangeListener(android.support.v7.widget.RecyclerView.OnChildAttachStateChangeListener listener) {
        throw new RuntimeException("Stub!");
    }

    public void removeOnChildAttachStateChangeListener(android.support.v7.widget.RecyclerView.OnChildAttachStateChangeListener listener) {
        throw new RuntimeException("Stub!");
    }

    public void clearOnChildAttachStateChangeListeners() {
        throw new RuntimeException("Stub!");
    }

    public void setLayoutManager(android.support.v7.widget.RecyclerView.LayoutManager layout) {
        throw new RuntimeException("Stub!");
    }

    public void setOnFlingListener(android.support.v7.widget.RecyclerView.OnFlingListener onFlingListener) {
        throw new RuntimeException("Stub!");
    }

    public android.support.v7.widget.RecyclerView.OnFlingListener getOnFlingListener() {
        throw new RuntimeException("Stub!");
    }

    public android.support.v7.widget.RecyclerView.LayoutManager getLayoutManager() {
        throw new RuntimeException("Stub!");
    }

    public android.support.v7.widget.RecyclerView.RecycledViewPool getRecycledViewPool() {
        throw new RuntimeException("Stub!");
    }

    public void setRecycledViewPool(android.support.v7.widget.RecyclerView.RecycledViewPool pool) {
        throw new RuntimeException("Stub!");
    }

    public void setViewCacheExtension(android.support.v7.widget.RecyclerView.ViewCacheExtension extension) {
        throw new RuntimeException("Stub!");
    }

    public void setItemViewCacheSize(int size) {
        throw new RuntimeException("Stub!");
    }

    public int getScrollState() {
        throw new RuntimeException("Stub!");
    }

    public void addItemDecoration(android.support.v7.widget.RecyclerView.ItemDecoration decor, int index) {
        throw new RuntimeException("Stub!");
    }

    public void addItemDecoration(android.support.v7.widget.RecyclerView.ItemDecoration decor) {
        throw new RuntimeException("Stub!");
    }

    public android.support.v7.widget.RecyclerView.ItemDecoration getItemDecorationAt(int index) {
        throw new RuntimeException("Stub!");
    }

    public int getItemDecorationCount() {
        throw new RuntimeException("Stub!");
    }

    public void removeItemDecorationAt(int index) {
        throw new RuntimeException("Stub!");
    }

    public void removeItemDecoration(android.support.v7.widget.RecyclerView.ItemDecoration decor) {
        throw new RuntimeException("Stub!");
    }

    public void setChildDrawingOrderCallback(android.support.v7.widget.RecyclerView.ChildDrawingOrderCallback childDrawingOrderCallback) {
        throw new RuntimeException("Stub!");
    }

    /**
     * @deprecated
     */
    @Deprecated
    public void setOnScrollListener(android.support.v7.widget.RecyclerView.OnScrollListener listener) {
        throw new RuntimeException("Stub!");
    }

    public void addOnScrollListener(android.support.v7.widget.RecyclerView.OnScrollListener listener) {
        throw new RuntimeException("Stub!");
    }

    public void removeOnScrollListener(android.support.v7.widget.RecyclerView.OnScrollListener listener) {
        throw new RuntimeException("Stub!");
    }

    public void clearOnScrollListeners() {
        throw new RuntimeException("Stub!");
    }

    public void scrollToPosition(int position) {
        throw new RuntimeException("Stub!");
    }

    public void smoothScrollToPosition(int position) {
        throw new RuntimeException("Stub!");
    }

    public void scrollTo(int x, int y) {
        throw new RuntimeException("Stub!");
    }

    public void scrollBy(int x, int y) {
        throw new RuntimeException("Stub!");
    }


    public int computeHorizontalScrollOffset() {
        throw new RuntimeException("Stub!");
    }

    public int computeHorizontalScrollExtent() {
        throw new RuntimeException("Stub!");
    }

    public int computeHorizontalScrollRange() {
        throw new RuntimeException("Stub!");
    }

    public int computeVerticalScrollOffset() {
        throw new RuntimeException("Stub!");
    }

    public int computeVerticalScrollExtent() {
        throw new RuntimeException("Stub!");
    }

    public int computeVerticalScrollRange() {
        throw new RuntimeException("Stub!");
    }

    public void setLayoutFrozen(boolean frozen) {
        throw new RuntimeException("Stub!");
    }

    public boolean isLayoutFrozen() {
        throw new RuntimeException("Stub!");
    }

    public void smoothScrollBy(int dx, int dy) {
        throw new RuntimeException("Stub!");
    }

    public void smoothScrollBy(int dx, int dy, Interpolator interpolator) {
        throw new RuntimeException("Stub!");
    }

    public boolean fling(int velocityX, int velocityY) {
        throw new RuntimeException("Stub!");
    }

    public void stopScroll() {
        throw new RuntimeException("Stub!");
    }

    public int getMinFlingVelocity() {
        throw new RuntimeException("Stub!");
    }

    public int getMaxFlingVelocity() {
        throw new RuntimeException("Stub!");
    }

    public void setEdgeEffectFactory(android.support.v7.widget.RecyclerView.EdgeEffectFactory edgeEffectFactory) {
        throw new RuntimeException("Stub!");
    }

    public android.support.v7.widget.RecyclerView.EdgeEffectFactory getEdgeEffectFactory() {
        throw new RuntimeException("Stub!");
    }

    public View focusSearch(View focused, int direction) {
        throw new RuntimeException("Stub!");
    }

    public void requestChildFocus(View child, View focused) {
        throw new RuntimeException("Stub!");
    }

    public boolean requestChildRectangleOnScreen(View child, Rect rect, boolean immediate) {
        throw new RuntimeException("Stub!");
    }

    public void addFocusables(ArrayList<View> views, int direction, int focusableMode) {
        throw new RuntimeException("Stub!");
    }

    public boolean isAttachedToWindow() {
        throw new RuntimeException("Stub!");
    }

    public void addOnItemTouchListener(android.support.v7.widget.RecyclerView.OnItemTouchListener listener) {
        throw new RuntimeException("Stub!");
    }

    public void removeOnItemTouchListener(android.support.v7.widget.RecyclerView.OnItemTouchListener listener) {
        throw new RuntimeException("Stub!");
    }

    public boolean onInterceptTouchEvent(MotionEvent e) {
        throw new RuntimeException("Stub!");
    }

    public void requestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        throw new RuntimeException("Stub!");
    }

    public boolean onTouchEvent(MotionEvent e) {
        throw new RuntimeException("Stub!");
    }

    public boolean onGenericMotionEvent(MotionEvent event) {
        throw new RuntimeException("Stub!");
    }


    public void setItemAnimator(android.support.v7.widget.RecyclerView.ItemAnimator animator) {
        throw new RuntimeException("Stub!");
    }

    public boolean isComputingLayout() {
        throw new RuntimeException("Stub!");
    }

    public void sendAccessibilityEventUnchecked(AccessibilityEvent event) {
        throw new RuntimeException("Stub!");
    }

    public android.support.v7.widget.RecyclerView.ItemAnimator getItemAnimator() {
        throw new RuntimeException("Stub!");
    }

    public void requestLayout() {
        throw new RuntimeException("Stub!");
    }

    public void draw(Canvas c) {
        throw new RuntimeException("Stub!");
    }

    public void onDraw(Canvas c) {
        throw new RuntimeException("Stub!");
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attrs) {
        throw new RuntimeException("Stub!");
    }

    public boolean isAnimating() {
        throw new RuntimeException("Stub!");
    }

    public void invalidateItemDecorations() {
        throw new RuntimeException("Stub!");
    }

    public boolean getPreserveFocusAfterLayout() {
        throw new RuntimeException("Stub!");
    }

    public void setPreserveFocusAfterLayout(boolean preserveFocusAfterLayout) {
        throw new RuntimeException("Stub!");
    }

    public android.support.v7.widget.RecyclerView.ViewHolder getChildViewHolder(View child) {
        throw new RuntimeException("Stub!");
    }

    public View findContainingItemView(View view) {
        throw new RuntimeException("Stub!");
    }

    public android.support.v7.widget.RecyclerView.ViewHolder findContainingViewHolder(View view) {
        throw new RuntimeException("Stub!");
    }


    /**
     * @deprecated
     */
    @Deprecated
    public int getChildPosition(View child) {
        throw new RuntimeException("Stub!");
    }

    public int getChildAdapterPosition(View child) {
        throw new RuntimeException("Stub!");
    }

    public int getChildLayoutPosition(View child) {
        throw new RuntimeException("Stub!");
    }

    public long getChildItemId(View child) {
        throw new RuntimeException("Stub!");
    }

    /**
     * @deprecated
     */
    @Deprecated
    public android.support.v7.widget.RecyclerView.ViewHolder findViewHolderForPosition(int position) {
        throw new RuntimeException("Stub!");
    }

    public android.support.v7.widget.RecyclerView.ViewHolder findViewHolderForLayoutPosition(int position) {
        throw new RuntimeException("Stub!");
    }

    public android.support.v7.widget.RecyclerView.ViewHolder findViewHolderForAdapterPosition(int position) {
        throw new RuntimeException("Stub!");
    }

    public android.support.v7.widget.RecyclerView.ViewHolder findViewHolderForItemId(long id) {
        throw new RuntimeException("Stub!");
    }

    public View findChildViewUnder(float x, float y) {
        throw new RuntimeException("Stub!");
    }

    public boolean drawChild(Canvas canvas, View child, long drawingTime) {
        throw new RuntimeException("Stub!");
    }

    public void offsetChildrenVertical(int dy) {
        throw new RuntimeException("Stub!");
    }

    public void onChildAttachedToWindow(View child) {
        throw new RuntimeException("Stub!");
    }

    public void onChildDetachedFromWindow(View child) {
        throw new RuntimeException("Stub!");
    }

    public void offsetChildrenHorizontal(int dx) {
        throw new RuntimeException("Stub!");
    }

    public void getDecoratedBoundsWithMargins(View view, Rect outBounds) {
        throw new RuntimeException("Stub!");
    }

    public void onScrolled(int dx, int dy) {
        throw new RuntimeException("Stub!");
    }

    public void onScrollStateChanged(int state) {
    }

    public boolean hasPendingAdapterUpdates() {
        throw new RuntimeException("Stub!");
    }

    public void setNestedScrollingEnabled(boolean enabled) {
        throw new RuntimeException("Stub!");
    }

    public boolean isNestedScrollingEnabled() {
        throw new RuntimeException("Stub!");
    }

    public boolean startNestedScroll(int axes) {
        throw new RuntimeException("Stub!");
    }

    public boolean startNestedScroll(int axes, int type) {
        throw new RuntimeException("Stub!");
    }

    public void stopNestedScroll() {
        throw new RuntimeException("Stub!");
    }

    public void stopNestedScroll(int type) {
        throw new RuntimeException("Stub!");
    }

    public boolean hasNestedScrollingParent() {
        throw new RuntimeException("Stub!");
    }

    public boolean hasNestedScrollingParent(int type) {
        throw new RuntimeException("Stub!");
    }

    public boolean dispatchNestedScroll(int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int[] offsetInWindow) {
        throw new RuntimeException("Stub!");
    }

    public boolean dispatchNestedScroll(int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int[] offsetInWindow, int type) {
        throw new RuntimeException("Stub!");
    }

    public boolean dispatchNestedPreScroll(int dx, int dy, int[] consumed, int[] offsetInWindow) {
        throw new RuntimeException("Stub!");
    }

    public boolean dispatchNestedPreScroll(int dx, int dy, int[] consumed, int[] offsetInWindow, int type) {
        throw new RuntimeException("Stub!");
    }

    public boolean dispatchNestedFling(float velocityX, float velocityY, boolean consumed) {
        throw new RuntimeException("Stub!");
    }

    public boolean dispatchNestedPreFling(float velocityX, float velocityY) {
        throw new RuntimeException("Stub!");
    }

    public interface ChildDrawingOrderCallback {
        int onGetChildDrawingOrder(int var1, int var2);
    }

    public abstract static class ItemAnimator {
        public static final int FLAG_CHANGED = 2;
        public static final int FLAG_REMOVED = 8;
        public static final int FLAG_INVALIDATED = 4;
        public static final int FLAG_MOVED = 2048;
        public static final int FLAG_APPEARED_IN_PRE_LAYOUT = 4096;

        public ItemAnimator() {
        }

        public long getMoveDuration() {
            throw new RuntimeException("Stub!");
        }

        public void setMoveDuration(long moveDuration) {
            throw new RuntimeException("Stub!");
        }

        public long getAddDuration() {
            throw new RuntimeException("Stub!");
        }

        public void setAddDuration(long addDuration) {
            throw new RuntimeException("Stub!");
        }

        public long getRemoveDuration() {
            throw new RuntimeException("Stub!");
        }

        public void setRemoveDuration(long removeDuration) {
            throw new RuntimeException("Stub!");
        }

        public long getChangeDuration() {
            throw new RuntimeException("Stub!");
        }

        public void setChangeDuration(long changeDuration) {
            throw new RuntimeException("Stub!");
        }

        void setListener(android.support.v7.widget.RecyclerView.ItemAnimator.ItemAnimatorListener listener) {
            throw new RuntimeException("Stub!");
        }

        public android.support.v7.widget.RecyclerView.ItemAnimator.ItemHolderInfo recordPreLayoutInformation(android.support.v7.widget.RecyclerView.State state, android.support.v7.widget.RecyclerView.ViewHolder viewHolder, int changeFlags, List<Object> payloads) {
            throw new RuntimeException("Stub!");
        }

        public android.support.v7.widget.RecyclerView.ItemAnimator.ItemHolderInfo recordPostLayoutInformation(android.support.v7.widget.RecyclerView.State state, android.support.v7.widget.RecyclerView.ViewHolder viewHolder) {
            throw new RuntimeException("Stub!");
        }

        public abstract boolean animateDisappearance(android.support.v7.widget.RecyclerView.ViewHolder var1, android.support.v7.widget.RecyclerView.ItemAnimator.ItemHolderInfo var2, android.support.v7.widget.RecyclerView.ItemAnimator.ItemHolderInfo var3);

        public abstract boolean animateAppearance(android.support.v7.widget.RecyclerView.ViewHolder var1, android.support.v7.widget.RecyclerView.ItemAnimator.ItemHolderInfo var2, android.support.v7.widget.RecyclerView.ItemAnimator.ItemHolderInfo var3);

        public abstract boolean animatePersistence(android.support.v7.widget.RecyclerView.ViewHolder var1, android.support.v7.widget.RecyclerView.ItemAnimator.ItemHolderInfo var2, android.support.v7.widget.RecyclerView.ItemAnimator.ItemHolderInfo var3);

        public abstract boolean animateChange(android.support.v7.widget.RecyclerView.ViewHolder var1, android.support.v7.widget.RecyclerView.ViewHolder var2, android.support.v7.widget.RecyclerView.ItemAnimator.ItemHolderInfo var3, android.support.v7.widget.RecyclerView.ItemAnimator.ItemHolderInfo var4);

        public abstract void runPendingAnimations();

        public abstract void endAnimation(android.support.v7.widget.RecyclerView.ViewHolder var1);

        public abstract void endAnimations();

        public abstract boolean isRunning();

        public final void dispatchAnimationFinished(android.support.v7.widget.RecyclerView.ViewHolder viewHolder) {
            throw new RuntimeException("Stub!");
        }

        public void onAnimationFinished(android.support.v7.widget.RecyclerView.ViewHolder viewHolder) {
        }

        public final void dispatchAnimationStarted(android.support.v7.widget.RecyclerView.ViewHolder viewHolder) {
            throw new RuntimeException("Stub!");
        }

        public void onAnimationStarted(android.support.v7.widget.RecyclerView.ViewHolder viewHolder) {
        }

        public final boolean isRunning(android.support.v7.widget.RecyclerView.ItemAnimator.ItemAnimatorFinishedListener listener) {
            throw new RuntimeException("Stub!");
        }

        public boolean canReuseUpdatedViewHolder(android.support.v7.widget.RecyclerView.ViewHolder viewHolder) {
            throw new RuntimeException("Stub!");
        }

        public boolean canReuseUpdatedViewHolder(android.support.v7.widget.RecyclerView.ViewHolder viewHolder, List<Object> payloads) {
            throw new RuntimeException("Stub!");
        }

        public final void dispatchAnimationsFinished() {
            throw new RuntimeException("Stub!");
        }

        public android.support.v7.widget.RecyclerView.ItemAnimator.ItemHolderInfo obtainHolderInfo() {
            throw new RuntimeException("Stub!");
        }

        public interface ItemAnimatorFinishedListener {
            void onAnimationsFinished();
        }

        interface ItemAnimatorListener {
            void onAnimationFinished(android.support.v7.widget.RecyclerView.ViewHolder var1);
        }

        public @interface AdapterChanges {
        }

        public static class ItemHolderInfo {
            public int left;
            public int top;
            public int right;
            public int bottom;
            public int changeFlags;

            public ItemHolderInfo() {
            }


            public android.support.v7.widget.RecyclerView.ItemAnimator.ItemHolderInfo setFrom(android.support.v7.widget.RecyclerView.ViewHolder holder) {
                throw new RuntimeException("Stub!");
            }


            public android.support.v7.widget.RecyclerView.ItemAnimator.ItemHolderInfo setFrom(android.support.v7.widget.RecyclerView.ViewHolder holder, int flags) {
                throw new RuntimeException("Stub!");
            }
        }
    }


    public abstract static class OnFlingListener {
        public OnFlingListener() {
        }

        public abstract boolean onFling(int var1, int var2);
    }

    public static class State {
        public State() {
        }


        public boolean isMeasuring() {
            throw new RuntimeException("Stub!");
        }

        public boolean isPreLayout() {
            throw new RuntimeException("Stub!");
        }

        public boolean willRunPredictiveAnimations() {
            throw new RuntimeException("Stub!");
        }

        public boolean willRunSimpleAnimations() {
            throw new RuntimeException("Stub!");
        }

        public void remove(int resourceId) {
            throw new RuntimeException("Stub!");
        }

        public <T> T get(int resourceId) {
            throw new RuntimeException("Stub!");
        }

        public void put(int resourceId, Object data) {
            throw new RuntimeException("Stub!");
        }

        public int getTargetScrollPosition() {
            throw new RuntimeException("Stub!");
        }

        public boolean hasTargetScrollPosition() {
            throw new RuntimeException("Stub!");
        }

        public boolean didStructureChange() {
            throw new RuntimeException("Stub!");
        }

        public int getItemCount() {
            throw new RuntimeException("Stub!");
        }

        public int getRemainingScrollHorizontal() {
            throw new RuntimeException("Stub!");
        }

        public int getRemainingScrollVertical() {
            throw new RuntimeException("Stub!");
        }

        public String toString() {
            throw new RuntimeException("Stub!");
        }
    }

    public static class SavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            public android.support.v7.widget.RecyclerView.SavedState createFromParcel(Parcel in, ClassLoader loader) {
                throw new RuntimeException("Stub!");
            }

            public android.support.v7.widget.RecyclerView.SavedState createFromParcel(Parcel in) {
                throw new RuntimeException("Stub!");
            }

            public android.support.v7.widget.RecyclerView.SavedState[] newArray(int size) {
                throw new RuntimeException("Stub!");
            }
        };
        Parcelable mLayoutState;

        public void writeToParcel(Parcel dest, int flags) {
            throw new RuntimeException("Stub!");
        }

    }

    static class AdapterDataObservable {

        public boolean hasObservers() {
            throw new RuntimeException("Stub!");
        }

        public void notifyChanged() {
            throw new RuntimeException("Stub!");
        }

        public void notifyItemRangeChanged(int positionStart, int itemCount) {
            throw new RuntimeException("Stub!");
        }

        public void notifyItemRangeChanged(int positionStart, int itemCount, Object payload) {
            throw new RuntimeException("Stub!");
        }

        public void notifyItemRangeInserted(int positionStart, int itemCount) {
            throw new RuntimeException("Stub!");
        }

        public void notifyItemRangeRemoved(int positionStart, int itemCount) {
            throw new RuntimeException("Stub!");
        }

        public void notifyItemMoved(int fromPosition, int toPosition) {
            throw new RuntimeException("Stub!");
        }
    }

    public abstract static class SmoothScroller {

        public SmoothScroller() {
        }

        public PointF computeScrollVectorForPosition(int targetPosition) {
            throw new RuntimeException("Stub!");
        }

        public android.support.v7.widget.RecyclerView.LayoutManager getLayoutManager() {
            throw new RuntimeException("Stub!");
        }

        public boolean isPendingInitialRun() {
            throw new RuntimeException("Stub!");
        }

        public boolean isRunning() {
            throw new RuntimeException("Stub!");
        }

        public int getTargetPosition() {
            throw new RuntimeException("Stub!");
        }

        public void setTargetPosition(int targetPosition) {
            throw new RuntimeException("Stub!");
        }

        public int getChildPosition(View view) {
            throw new RuntimeException("Stub!");
        }

        public int getChildCount() {
            throw new RuntimeException("Stub!");
        }

        public View findViewByPosition(int position) {
            throw new RuntimeException("Stub!");
        }

        /**
         * @deprecated
         */
        @Deprecated
        public void instantScrollToPosition(int position) {
            throw new RuntimeException("Stub!");
        }

        public interface ScrollVectorProvider {
            PointF computeScrollVectorForPosition(int var1);
        }

        public static class Action {
            public static final int UNDEFINED_DURATION = -2147483648;

            public Action(int dx, int dy) {
                throw new RuntimeException("Stub!");
            }

            public Action(int dx, int dy, int duration) {
                throw new RuntimeException("Stub!");
            }

            public Action(int dx, int dy, int duration, Interpolator interpolator) {
                throw new RuntimeException("Stub!");
            }

            public void jumpTo(int targetPosition) {
                throw new RuntimeException("Stub!");
            }

            public int getDx() {
                throw new RuntimeException("Stub!");
            }

            public void setDx(int dx) {
                throw new RuntimeException("Stub!");
            }


            public int getDy() {
                throw new RuntimeException("Stub!");
            }

            public void setDy(int dy) {
                throw new RuntimeException("Stub!");
            }

            public int getDuration() {
                throw new RuntimeException("Stub!");
            }

            public void setDuration(int duration) {
                throw new RuntimeException("Stub!");
            }


            public Interpolator getInterpolator() {
                throw new RuntimeException("Stub!");
            }

            public void setInterpolator(Interpolator interpolator) {
                throw new RuntimeException("Stub!");
            }

            public void update(int dx, int dy, int duration, Interpolator interpolator) {
                throw new RuntimeException("Stub!");
            }
        }
    }

    public abstract static class AdapterDataObserver {
        public AdapterDataObserver() {
        }

        public void onChanged() {
        }

        public void onItemRangeChanged(int positionStart, int itemCount) {
        }

        public void onItemRangeChanged(int positionStart, int itemCount, Object payload) {
            throw new RuntimeException("Stub!");
        }

        public void onItemRangeInserted(int positionStart, int itemCount) {
        }

        public void onItemRangeRemoved(int positionStart, int itemCount) {
        }

        public void onItemRangeMoved(int fromPosition, int toPosition, int itemCount) {
        }
    }

    public static class LayoutParams extends MarginLayoutParams {
        public LayoutParams(Context c, AttributeSet attrs) {
            throw new RuntimeException("Stub!");
        }

        public LayoutParams(int width, int height) {
            throw new RuntimeException("Stub!");
        }

        public LayoutParams(MarginLayoutParams source) {
            throw new RuntimeException("Stub!");
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams source) {
            throw new RuntimeException("Stub!");
        }

        public LayoutParams(android.support.v7.widget.RecyclerView.LayoutParams source) {
            throw new RuntimeException("Stub!");
        }

        public boolean viewNeedsUpdate() {
            throw new RuntimeException("Stub!");
        }

        public boolean isViewInvalid() {
            throw new RuntimeException("Stub!");
        }

        public boolean isItemRemoved() {
            throw new RuntimeException("Stub!");
        }

        public boolean isItemChanged() {
            throw new RuntimeException("Stub!");
        }

        /**
         * @deprecated
         */
        @Deprecated
        public int getViewPosition() {
            throw new RuntimeException("Stub!");
        }

        public int getViewLayoutPosition() {
            throw new RuntimeException("Stub!");
        }

        public int getViewAdapterPosition() {
            throw new RuntimeException("Stub!");
        }
    }

    public abstract static class ViewHolder {
        public final View itemView;

        public ViewHolder(View itemView) {
            throw new RuntimeException("Stub!");
        }

        /**
         * @deprecated
         */
        @Deprecated
        public final int getPosition() {
            throw new RuntimeException("Stub!");
        }

        public final int getLayoutPosition() {
            throw new RuntimeException("Stub!");
        }

        public final int getAdapterPosition() {
            throw new RuntimeException("Stub!");
        }

        public final int getOldPosition() {
            throw new RuntimeException("Stub!");
        }

        public final long getItemId() {
            throw new RuntimeException("Stub!");
        }

        public final int getItemViewType() {
            throw new RuntimeException("Stub!");
        }

        public String toString() {
            throw new RuntimeException("Stub!");
        }

        public final void setIsRecyclable(boolean recyclable) {
            throw new RuntimeException("Stub!");
        }

        public final boolean isRecyclable() {
            throw new RuntimeException("Stub!");
        }

        boolean shouldBeKeptAsChild() {
            throw new RuntimeException("Stub!");
        }

        boolean doesTransientStatePreventRecycling() {
            throw new RuntimeException("Stub!");
        }

        boolean isUpdated() {
            throw new RuntimeException("Stub!");
        }
    }

    public interface OnChildAttachStateChangeListener {
        void onChildViewAttachedToWindow(View var1);

        void onChildViewDetachedFromWindow(View var1);
    }

    public interface RecyclerListener {
        void onViewRecycled(android.support.v7.widget.RecyclerView.ViewHolder var1);
    }

    public abstract static class OnScrollListener {
        public OnScrollListener() {
        }

        public void onScrollStateChanged(android.support.v7.widget.RecyclerView recyclerView, int newState) {
        }

        public void onScrolled(android.support.v7.widget.RecyclerView recyclerView, int dx, int dy) {
        }
    }

    public static class SimpleOnItemTouchListener implements android.support.v7.widget.RecyclerView.OnItemTouchListener {
        public SimpleOnItemTouchListener() {
        }

        public boolean onInterceptTouchEvent(android.support.v7.widget.RecyclerView rv, MotionEvent e) {
            throw new RuntimeException("Stub!");
        }

        public void onTouchEvent(android.support.v7.widget.RecyclerView rv, MotionEvent e) {
        }

        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        }
    }

    public interface OnItemTouchListener {
        boolean onInterceptTouchEvent(android.support.v7.widget.RecyclerView var1, MotionEvent var2);

        void onTouchEvent(android.support.v7.widget.RecyclerView var1, MotionEvent var2);

        void onRequestDisallowInterceptTouchEvent(boolean var1);
    }

    public abstract static class ItemDecoration {
        public ItemDecoration() {
        }

        public void onDraw(Canvas c, android.support.v7.widget.RecyclerView parent, android.support.v7.widget.RecyclerView.State state) {
            throw new RuntimeException("Stub!");
        }

        /**
         * @deprecated
         */
        @Deprecated
        public void onDraw(Canvas c, android.support.v7.widget.RecyclerView parent) {
        }

        public void onDrawOver(Canvas c, android.support.v7.widget.RecyclerView parent, android.support.v7.widget.RecyclerView.State state) {
            throw new RuntimeException("Stub!");
        }

        /**
         * @deprecated
         */
        @Deprecated
        public void onDrawOver(Canvas c, android.support.v7.widget.RecyclerView parent) {
        }

        /**
         * @deprecated
         */
        @Deprecated
        public void getItemOffsets(Rect outRect, int itemPosition, android.support.v7.widget.RecyclerView parent) {
            throw new RuntimeException("Stub!");
        }

        public void getItemOffsets(Rect outRect, View view, android.support.v7.widget.RecyclerView parent, android.support.v7.widget.RecyclerView.State state) {
            throw new RuntimeException("Stub!");
        }
    }

    public abstract static class LayoutManager {
        public LayoutManager() {
            throw new RuntimeException("Stub!");
        }

        public void
        c

        int chooseSize(int spec, int desired, int min) {
            throw new RuntimeException("Stub!");
        }

        public void
        ted */

        @Deprecated
        public static int getChildMeasureSpec(int parentSize, int padding, int childDimension, boolean canScroll) {
            throw new RuntimeException("Stub!");
        }

        public stad
        c

        int getChildMeasureSpec(int parentSize, int parentMode, int padding, int childDimension, boolean canScroll) {
            throw new RuntimeException("Stub!");
        }

        public intti
        c android.

        support.v7.widget.RecyclerView.LayoutManager.Properties getProperties(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
            throw new RuntimeException("Stub!");
        }

        public stad
        setMeasuredDimension(Rect childrenBounds, int wSpec, int hSpec) {
            throw new RuntimeException("Stub!");
        }

        public voica
        requestLayout() {
            throw new RuntimeException("Stub!");
        }

        public voile
        assertInLayoutOrScroll(String message) {
            throw new RuntimeException("Stub!");
        }

        public stale
        assertNotInLayoutOrScroll(String message) {
            throw new RuntimeException("Stub!");
        }

        /**
         * @depreal an isAutoMeasureEnabled() {
         * throw new RuntimeException("Stub!");
         * }
         * <p>
         * public booal
         * ted
         */
        @Deprecated
        public void setAutoMeasureEnabled(boolean enabled) {
            throw new RuntimeException("Stub!");
        }

        public bood

        an supportsPredictiveItemAnimations() {
            throw new RuntimeException("Stub!");
        }

        public find

        boolean isItemPrefetchEnabled() {
            throw new RuntimeException("Stub!");
        }

        public voile

        void setItemPrefetchEnabled(boolean enabled) {
            throw new RuntimeException("Stub!");
        }

        public find
        collectAdjacentPrefetchPositions(int dx, int dy, android.support.v7.widget.RecyclerView.State state, android.support.v7.widget.RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        }

        public voile
        collectInitialPrefetchPositions(int adapterItemCount, android.support.v7.widget.RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        }

        public bood

        an isAttachedToWindow() {
            throw new RuntimeException("Stub!");
        }

        public voica
        postOnAnimation(Runnable action) {
            throw new RuntimeException("Stub!");
        }

        public bood

        an removeCallbacks(Runnable action) {
            throw new RuntimeException("Stub!");
        }

        public voile
        onAttachedToWindow(android.support.v7.widget.RecyclerView view) {
            throw new RuntimeException("Stub!");
        }

        /**
         * @depred ted
         */
        @Deprecated
        public void onDetachedFromWindow(android.support.v7.widget.RecyclerView view) {
            throw new RuntimeException("Stub!");
        }

        public void
        onDetachedFromWindow(android.support.v7.widget.RecyclerView view, android.support.v7.widget.RecyclerView.Recycler recycler) {
            throw new RuntimeException("Stub!");
        }

        public bootr

        an getClipToPadding() {
            throw new RuntimeException("Stub!");
        }

        public voile
        onLayoutChildren(android.support.v7.widget.RecyclerView.Recycler recycler, android.support.v7.widget.RecyclerView.State state) {
            throw new RuntimeException("Stub!");
        }

        public voiro
        onLayoutCompleted(android.support.v7.widget.RecyclerView.State state) {
        }

        public absro
        act android.

        support.v7.widget.RecyclerView.LayoutParams generateDefaultLayoutParams();

        public boo s

        an checkLayoutParams(android.support.v7.widget.RecyclerView.LayoutParams lp) {
            throw new RuntimeException("Stub!");
        }

        public and s

        id.support.v7.widget.RecyclerView.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams lp) {
            throw new RuntimeException("Stub!");
        }

        public andle

        id.support.v7.widget.RecyclerView.LayoutParams generateLayoutParams(Context c, AttributeSet attrs) {
            throw new RuntimeException("Stub!");
        }

        public intle
        crollHorizontallyBy(int dx, android.support.v7.widget.RecyclerView.Recycler recycler, android.support.v7.widget.RecyclerView.State state) {
            return 0;
        }

        public intd
        crollVerticallyBy(int dy, android.support.v7.widget.RecyclerView.Recycler recycler, android.support.v7.widget.RecyclerView.State state) {
            return 0;
        }

        public bood

        an canScrollHorizontally() {
            return false;
        }

        public bood

        an canScrollVertically() {
            return false;
        }

        public voile
        scrollToPosition(int position) {
        }

        public voi g

        smoothScrollToPosition(android.support.v7.widget.RecyclerView recyclerView, android.support.v7.widget.RecyclerView.State state, int position) {
            throw new RuntimeException("Stub!");
        }

        public void
        startSmoothScroll(android.support.v7.widget.RecyclerView.SmoothScroller smoothScroller) {
            throw new RuntimeException("Stub!");
        }

        public bood

        an isSmoothScrolling() {
            throw new RuntimeException("Stub!");
        }

        public intd
        etLayoutDirection() {
            throw new RuntimeException("Stub!");
        }

        public void
        endAnimation(View view) {
            throw new RuntimeException("Stub!");
        }

        public void
        addDisappearingView(View child) {
            throw new RuntimeException("Stub!");
        }

        public void
        addDisappearingView(View child, int index) {
            throw new RuntimeException("Stub!");
        }

        public void
        addView(View child) {
            throw new RuntimeException("Stub!");
        }

        public void
        addView(View child, int index) {
            throw new RuntimeException("Stub!");
        }

        public voi g

        removeView(View child) {
            throw new RuntimeException("Stub!");
        }

        public voi g

        removeViewAt(int index) {
            throw new RuntimeException("Stub!");
        }

        public voi g

        removeAllViews() {
            throw new RuntimeException("Stub!");
        }

        public int

        public View
        etBaseline() {
            throw new RuntimeException("Stub!");
        }

        public int

        public View
        etPosition(View view) {
            throw new RuntimeException("Stub!");
        }

        public intd
        etItemViewType(View view) {
            throw new RuntimeException("Stub!");
        }


        d
        findContainingItemView(View view) {
            throw new RuntimeException("Stub!");
        }


        d
        findViewByPosition(int position) {
            throw new RuntimeException("Stub!");
        }

        public void
        detachView(View child) {
            throw new RuntimeException("Stub!");
        }

        public void
        detachViewAt(int index) {
            throw new RuntimeException("Stub!");
        }

        public void
        attachView(View child, int index, android.support.v7.widget.RecyclerView.LayoutParams lp) {
            throw new RuntimeException("Stub!");
        }

        public void
        attachView(View child, int index) {
            throw new RuntimeException("Stub!");
        }

        public void
        attachView(View child) {
            throw new RuntimeException("Stub!");
        }

        public void
        removeDetachedView(View child) {
            throw new RuntimeException("Stub!");
        }

        public void
        moveView(int fromIndex, int toIndex) {
            throw new RuntimeException("Stub!");
        }

        public void
        detachAndScrapView(View child, android.support.v7.widget.RecyclerView.Recycler recycler) {
            throw new RuntimeException("Stub!");
        }

        public voi g

        detachAndScrapViewAt(int index, android.support.v7.widget.RecyclerView.Recycler recycler) {
            throw new RuntimeException("Stub!");
        }

        public voi

        public View
        removeAndRecycleView(View child, android.support.v7.widget.RecyclerView.Recycler recycler) {
            throw new RuntimeException("Stub!");
        }

        public voi g

        removeAndRecycleViewAt(int index, android.support.v7.widget.RecyclerView.Recycler recycler) {
            View view = this.getChildAt(index);
            this.removeViewAt(index);
            recycler.recycleView(view);
        }

        public int g

        etChildCount() {
            throw new RuntimeException("Stub!");
        }


        public int g

        getChildAt(int index) {
            throw new RuntimeException("Stub!");
        }

        public int
        public int g

        etWidthMode() {
            throw new RuntimeException("Stub!");
        }

        public int
        public int g

        etHeightMode() {
            throw new RuntimeException("Stub!");
        }


        public int g

        etWidth() {
            throw new RuntimeException("Stub!");
        }


        public int g

        etHeight() {
            throw new RuntimeException("Stub!");
        }


        public int g

        etPaddingLeft() {
            throw new RuntimeException("Stub!");
        }


        public int g

        etPaddingTop() {
            throw new RuntimeException("Stub!");
        }


        public int g

        etPaddingRight() {
            throw new RuntimeException("Stub!");
        }


        le
        etPaddingBottom() {
            throw new RuntimeException("Stub!");
        }


        le
        etPaddingStart() {
            throw new RuntimeException("Stub!");
        }


        public View
        etPaddingEnd() {
            throw new RuntimeException("Stub!");
        }

        public boo g

        an isFocused() {
            throw new RuntimeException("Stub!");
        }

        public bood

        an hasFocus() {
            throw new RuntimeException("Stub!");
        }


        d
        getFocusedChild() {
            throw new RuntimeException("Stub!");
        }

        public intd
        etItemCount() {
            throw new RuntimeException("Stub!");
        }

        public void
        offsetChildrenHorizontal(int dx) {
            throw new RuntimeException("Stub!");
        }

        public void
        offsetChildrenVertical(int dy) {
            throw new RuntimeException("Stub!");
        }

        public void
        ignoreView(View view) {
            throw new RuntimeException("Stub!");
        }

        public voile
        stopIgnoringView(View view) {
            throw new RuntimeException("Stub!");
        }

        public void
        detachAndScrapAttachedViews(android.support.v7.widget.RecyclerView.Recycler recycler) {
            throw new RuntimeException("Stub!");
        }

        public void
        measureChild(View child, int widthUsed, int heightUsed) {
            throw new RuntimeException("Stub!");
        }

        public booca

        an isMeasurementCacheEnabled() {
            throw new RuntimeException("Stub!");
        }

        public voiti
        setMeasurementCacheEnabled(boolean measurementCacheEnabled) {
            throw new RuntimeException("Stub!");
        }

        public voi g

        measureChildWithMargins(View child, int widthUsed, int heightUsed) {
            throw new RuntimeException("Stub!");
        }

        /**
         * @depre g
         * etDecoratedMeasuredWidth(View child) {
         * throw new RuntimeException("Stub!");
         * }
         * <p>
         * public intd
         * etDecoratedMeasuredHeight(View child) {
         * throw new RuntimeException("Stub!");
         * }
         * <p>
         * public void
         * layoutDecorated(View child, int left, int top, int right, int bottom) {
         * throw new RuntimeException("Stub!");
         * }
         * <p>
         * public void
         * layoutDecoratedWithMargins(View child, int left, int top, int right, int bottom) {
         * throw new RuntimeException("Stub!");
         * }
         * <p>
         * public void
         * getTransformedBoundingBox(View child, boolean includeDecorInsets, Rect out) {
         * throw new RuntimeException("Stub!");
         * }
         * <p>
         * public voi g
         * getDecoratedBoundsWithMargins(View view, Rect outBounds) {
         * throw new RuntimeException("Stub!");
         * }
         * <p>
         * public int g
         * etDecoratedLeft(View child) {
         * throw new RuntimeException("Stub!");
         * }
         * <p>
         * public int g
         * etDecoratedTop(View child) {
         * throw new RuntimeException("Stub!");
         * }
         * <p>
         * public int g
         * etDecoratedRight(View child) {
         * throw new RuntimeException("Stub!");
         * }
         * <p>
         * public intd
         * etDecoratedBottom(View child) {
         * throw new RuntimeException("Stub!");
         * }
         * <p>
         * public voi g
         * calculateItemDecorationsForChild(View child, Rect outRect) {
         * throw new RuntimeException("Stub!");
         * }
         * <p>
         * public int g
         * etTopDecorationHeight(View child) {
         * throw new RuntimeException("Stub!");
         * }
         * <p>
         * public int g
         * etBottomDecorationHeight(View child) {
         * throw new RuntimeException("Stub!");
         * }
         * <p>
         * public int g
         * etLeftDecorationWidth(View child) {
         * throw new RuntimeException("Stub!");
         * }
         * <p>
         * public int   public View
         * etRightDecorationWidth(View child) {
         * throw new RuntimeException("Stub!");
         * }
         * <p>
         * <p>
         * public View
         * onFocusSearchFailed(View focused, int direction, android.support.v7.widget.RecyclerView.Recycler recycler, android.support.v7.widget.RecyclerView.State state) {
         * throw new RuntimeException("Stub!");
         * }
         * <p>
         * <p>
         * le
         * onInterceptFocusSearch(View focused, int direction) {
         * throw new RuntimeException("Stub!");
         * }
         * <p>
         * public boole
         * an requestChildRectangleOnScreen(android.support.v7.widget.RecyclerView parent, View child, Rect rect, boolean immediate) {
         * throw new RuntimeException("Stub!");
         * }
         * <p>
         * public boole
         * an requestChildRectangleOnScreen(android.support.v7.widget.RecyclerView parent, View child, Rect rect, boolean immediate, boolean focusedChildVisible) {
         * throw new RuntimeException("Stub!");
         * }
         * <p>
         * public booca
         * an isViewPartiallyVisible(View child, boolean completelyVisible, boolean acceptEndPointInclusion) {
         * throw new RuntimeException("Stub!");
         * }
         * <p>
         * /** @deprele
         * ted
         */
        @Deprecated
        public boolean onRequestChildFocus(android.support.v7.widget.RecyclerView parent, View child, View focused) {
            throw new RuntimeException("Stub!");
        }

        public bood

        an onRequestChildFocus(android.support.v7.widget.RecyclerView parent, android.support.v7.widget.RecyclerView.State state, View child, View focused) {
            throw new RuntimeException("Stub!");
        }

        public voile
        onAdapterChanged(android.support.v7.widget.RecyclerView.Adapter oldAdapter, android.support.v7.widget.RecyclerView.Adapter newAdapter) {
        }

        public bood

        an onAddFocusables(android.support.v7.widget.RecyclerView recyclerView, ArrayList<View> views, int direction, int focusableMode) {
            throw new RuntimeException("Stub!");
        }

        public void
        onItemsChanged(android.support.v7.widget.RecyclerView recyclerView) {
        }

        public void
        onItemsAdded(android.support.v7.widget.RecyclerView recyclerView, int positionStart, int itemCount) {
        }

        public void
        onItemsRemoved(android.support.v7.widget.RecyclerView recyclerView, int positionStart, int itemCount) {
        }

        public void
        onItemsUpdated(android.support.v7.widget.RecyclerView recyclerView, int positionStart, int itemCount) {
        }

        public void
        onItemsUpdated(android.support.v7.widget.RecyclerView recyclerView, int positionStart, int itemCount, Object payload) {
            throw new RuntimeException("Stub!");
        }

        public voi c

        onItemsMoved(android.support.v7.widget.RecyclerView recyclerView, int from, int to, int itemCount) {
        }

        public int c

        omputeHorizontalScrollExtent(android.support.v7.widget.RecyclerView.State state) {
            throw new RuntimeException("Stub!");
        }

        public int c

        omputeHorizontalScrollOffset(android.support.v7.widget.RecyclerView.State state) {
            throw new RuntimeException("Stub!");
        }

        public int c

        omputeHorizontalScrollRange(android.support.v7.widget.RecyclerView.State state) {
            throw new RuntimeException("Stub!");
        }

        public int c

        omputeVerticalScrollExtent(android.support.v7.widget.RecyclerView.State state) {
            throw new RuntimeException("Stub!");
        }

        public int c

        omputeVerticalScrollOffset(android.support.v7.widget.RecyclerView.State state) {
            throw new RuntimeException("Stub!");
        }

        public intd
        omputeVerticalScrollRange(android.support.v7.widget.RecyclerView.State state) {
            throw new RuntimeException("Stub!");
        }

        public void
        onMeasure(android.support.v7.widget.RecyclerView.Recycler recycler, android.support.v7.widget.RecyclerView.State state, int widthSpec, int heightSpec) {
            throw new RuntimeException("Stub!");
        }

        public voi
        public int g

        setMeasuredDimension(int widthSize, int heightSize) {
            throw new RuntimeException("Stub!");
        }

        public int g

        etMinimumWidth() {
            throw new RuntimeException("Stub!");
        }

        public Parce
        etMinimumHeight() {
            throw new RuntimeException("Stub!");
        }

        d

        lable onSaveInstanceState() {
            throw new RuntimeException("Stub!");
        }

        public void
        onRestoreInstanceState(Parcelable state) {
        }

        public void
        onScrollStateChanged(int state) {
        }

        public void
        removeAndRecycleAllViews(android.support.v7.widget.RecyclerView.Recycler recycler) {
            throw new RuntimeException("Stub!");
        }

        public void
        onInitializeAccessibilityNodeInfo(android.support.v7.widget.RecyclerView.Recycler recycler, android.support.v7.widget.RecyclerView.State state, AccessibilityNodeInfoCompat info) {
            throw new RuntimeException("Stub!");
        }

        public void
        onInitializeAccessibilityEvent(AccessibilityEvent event) {
            throw new RuntimeException("Stub!");
        }

        public voiid
        onInitializeAccessibilityEvent(android.support.v7.widget.RecyclerView.Recycler recycler, android.support.v7.widget.RecyclerView.State state, AccessibilityEvent event) {
            throw new RuntimeException("Stub!");
        }


        public vod
        onInitializeAccessibilityNodeInfoForItem(android.support.v7.widget.RecyclerView.Recycler recycler, android.support.v7.widget.RecyclerView.State state, View host, AccessibilityNodeInfoCompat info) {
            throw new RuntimeException("Stub!");
        }

        public voi g

        requestSimpleAnimationsInNextLayout() {
            throw new RuntimeException("Stub!");
        }

        public int g

        etSelectionModeForAccessibility(android.support.v7.widget.RecyclerView.Recycler recycler, android.support.v7.widget.RecyclerView.State state) {
            throw new RuntimeException("Stub!");
        }

        public int g

        etRowCountForAccessibility(android.support.v7.widget.RecyclerView.Recycler recycler, android.support.v7.widget.RecyclerView.State state) {
            throw new RuntimeException("Stub!");
        }

        public intle
        etColumnCountForAccessibility(android.support.v7.widget.RecyclerView.Recycler recycler, android.support.v7.widget.RecyclerView.State state) {
            throw new RuntimeException("Stub!");
        }

        public boole

        an isLayoutHierarchical(android.support.v7.widget.RecyclerView.Recycler recycler, android.support.v7.widget.RecyclerView.State state) {
            throw new RuntimeException("Stub!");
        }

        public boo public boole

        an performAccessibilityAction(android.support.v7.widget.RecyclerView.Recycler recycler, android.support.v7.widget.RecyclerView.State state, int action, Bundle args) {
            throw new RuntimeException("Stub!");
        }

        ti

        an performAccessibilityActionForItem(android.support.v7.widget.RecyclerView.Recycler recycler, android.support.v7.widget.RecyclerView.State state, View view, int action, Bundle args) {
            throw new RuntimeException("Stub!");
        }

        public statiface LayoutPrefetchRegistry

        {
            void addPosition ( int var1, int var2);
        }
    }

    publer
    c

    class Properties {
        public int orientation;
        public int spanCount;
        public boolean reverseLayout;
        public boolean stackFromEnd;

        public Properties() {
        }
    }

    public intic

    abstract static class Adapter<VH extends android.support.v7.widget.RecyclerView.ViewHolder> {
        public Adapter() {
        }


        public abstract VH onCreateViewHolder(ViewGroup var1, int var2);

        public abstract void onBindViewHolder(VH var1, int var2);

        public void onBindViewHolder(VH holder, int position, List<Object> payloads) {
            throw new RuntimeException("Stub!");
        }


        public final VH createViewHolder(ViewGroup parent, int viewType) {
            throw new RuntimeException("Stub!");
        }

        public final void bindViewHolder(VH holder, int position) {
            throw new RuntimeException("Stub!");
        }

        public int getItemViewType(int position) {
            throw new RuntimeException("Stub!");
        }

        public void setHasStableIds(boolean hasStableIds) {
            throw new RuntimeException("Stub!");
        }

        public long getItemId(int position) {
            throw new RuntimeException("Stub!");
        }

        public abstract int getItemCount();

        public final boolean hasStableIds() {
            throw new RuntimeException("Stub!");
        }

        public void onViewRecycled(VH holder) {
        }

        public boolean onFailedToRecycleView(VH holder) {
            throw new RuntimeException("Stub!");
        }

        public void onViewAttachedToWindow(VH holder) {
        }

        public void onViewDetachedFromWindow(VH holder) {
        }

        public final boolean hasObservers() {
            throw new RuntimeException("Stub!");
        }

        public void registerAdapterDataObserver(android.support.v7.widget.RecyclerView.AdapterDataObserver observer) {
            throw new RuntimeException("Stub!");
        }

        public void unregisterAdapterDataObserver(android.support.v7.widget.RecyclerView.AdapterDataObserver observer) {
            throw new RuntimeException("Stub!");
        }

        public void onAttachedToRecyclerView(android.support.v7.widget.RecyclerView recyclerView) {
        }

        public void onDetachedFromRecyclerView(android.support.v7.widget.RecyclerView recyclerView) {
        }

        public final void notifyDataSetChanged() {
            throw new RuntimeException("Stub!");
        }

        public final void notifyItemChanged(int position) {
            throw new RuntimeException("Stub!");
        }

        public final void notifyItemChanged(int position, Object payload) {
            throw new RuntimeException("Stub!");
        }

        public final void notifyItemRangeChanged(int positionStart, int itemCount) {
            throw new RuntimeException("Stub!");
        }

        public final void notifyItemRangeChanged(int positionStart, int itemCount, Object payload) {
            throw new RuntimeException("Stub!");
        }

        public final void notifyItemInserted(int position) {
            throw new RuntimeException("Stub!");
        }

        public final void notifyItemMoved(int fromPosition, int toPosition) {
            throw new RuntimeException("Stub!");
        }

        public final void notifyItemRangeInserted(int positionStart, int itemCount) {
            throw new RuntimeException("Stub!");
        }

        public final void notifyItemRemoved(int position) {
            throw new RuntimeException("Stub!");
        }

        public final void notifyItemRangeRemoved(int positionStart, int itemCount) {
            throw new RuntimeException("Stub!");
        }
    }

    public abstract static class ViewCacheExtension {
        public ViewCacheExtension() {
        }


        public abstract View getViewForPositionAndType(android.support.v7.widget.RecyclerView.Recycler var1, int var2, int var3);
    }

    public final cla

    private class ItemAnimatorRestoreListener implements android.support.v7.widget.RecyclerView.ItemAnimator.ItemAnimatorListener {
        public void onAnimationFinished(android.support.v7.widget.RecyclerView.ViewHolder item) {
            throw new RuntimeException("Stub!");
        }
    }

    EdgeEffectFactory

    {
        public static final int DIRECTION_LEFT = 0;
        public static final int DIRECTION_TOP = 1;
        public static final int DIRECTION_RIGHT = 2;
        public static final int DIRECTION_BOTTOM = 3;

        public EdgeEffectFactory() {
    }

        @Retention(RetentionPolicy.SOURCE)
        public @interface EdgeDirection {
        }
    }

    public static cl
    ss Recycler

    {
            public Recycler() {
        throw new RuntimeException("Stub!");
    }

        public void clear () {
        throw new RuntimeException("Stub!");
    }

        public void setViewCacheSize ( int viewCount){
        throw new RuntimeException("Stub!");
    }


        public List<ViewHolder> getScrapList () {
        throw new RuntimeException("Stub!");
    }

        public void bindViewToPosition (View view,int position){
        throw new RuntimeException("Stub!");
    }

        public int convertPreLayoutPositionToPostLayout ( int position){
        throw new RuntimeException("Stub!");
    }

        public View getViewForPosition ( int position){
        throw new RuntimeException("Stub!");
    }

        public void recycleView (View view){
        throw new RuntimeException("Stub!");
    }
    }

    public static classass RecycledViewPool

    {
            public RecycledViewPool() {
    }

        public void clear () {
        throw new RuntimeException("Stub!");
    }

        public void setMaxRecycledViews ( int viewType, int max){
        throw new RuntimeException("Stub!");
    }

        public int getRecycledViewCount ( int viewType){
        throw new RuntimeException("Stub!");
    }


        public android.support.v7.widget.RecyclerView.ViewHolder getRecycledView ( int viewType){
        throw new RuntimeException("Stub!");
    }

        public void putRecycledView (android.support.v7.widget.RecyclerView.ViewHolder scrap){
        throw new RuntimeException("Stub!");
    }
    }
}