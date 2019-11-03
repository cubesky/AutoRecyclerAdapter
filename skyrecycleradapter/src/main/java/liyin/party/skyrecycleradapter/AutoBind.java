package liyin.party.skyrecycleradapter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Deprecated
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface AutoBind {
    String view_id();
    String view_method();
    Class<?>[] view_param();
    String wrapTo() default "";
}
