package party.liyin.aralib;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.FIELD)
public @interface ARABind {
    int view_id();

    Class view_type();

    String view_method();

    Class<?>[] view_param() default void.class;

    String wrapTo() default "";
}
