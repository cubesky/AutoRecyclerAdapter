package party.liyin.aralib;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Bind data to View
 */
@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.FIELD)
public @interface ARABind {
    /**
     * View ID from R.java
     * E.g: R.id.textView
     *
     * @return View ID
     */
    int view_id();

    /**
     * Class instance for View Type
     * E.g: TextView.class
     * @return Child class for View.class
     */
    Class view_type();

    /**
     * Method you want to set.
     * E.g: setText
     * @return String of method
     */
    String view_method();

    /**
     * (Optional) Method parameter for view_method. If it has more than one parameter, set this to the type of parameter class.
     * E.g: {int.class, float.class}
     * @return Array of parameter type
     */
    Class<?>[] view_param() default void.class;

    String wrapTo() default "";
}
