package party.liyin.aralib;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Link View itself to Bean
 */
@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.FIELD)
public @interface ARALink {
    /**
     * View ID from R.java
     * E.g: R.id.textView
     *
     * @return View ID
     */
    int view_id();
}
