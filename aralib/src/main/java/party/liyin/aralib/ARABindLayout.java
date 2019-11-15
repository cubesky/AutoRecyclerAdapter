package party.liyin.aralib;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Register to SmartRecyclerAdapter
 */
@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.TYPE)
public @interface ARABindLayout {
    /**
     * Layout ID from R.layout
     *
     * @return LayoutID
     */
    int value();
}
