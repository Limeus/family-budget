package com.limeus.commonlib.annotation;

import com.limeus.commonlib.config.ResourceServerConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({ResourceServerConfig.class})
public @interface FamilyBudgetResourceServer {
}