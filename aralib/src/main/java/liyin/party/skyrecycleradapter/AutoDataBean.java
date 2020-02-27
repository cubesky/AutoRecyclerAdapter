package liyin.party.skyrecycleradapter;

import android.app.Activity;

/**
 * Abstract AutoDataBean, the superclass for all DataBean used in SmartRecyclerAdapter
 */
public abstract class AutoDataBean {
    /**
     * If this Bean is Init by SmartRecyclerAdapter.
     */
    public boolean isInit = false;
    /**
     * Activity which this bean is shown.
     */
    protected Activity activity = null;
}
