package io.github.davidrodrigues.validation;

import io.github.davidrodrigues.validation.constraintvalidation.NotEmptyListValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = NotEmptyListValidator.class)
public @interface NotEmptyList {

    String message() default "{campo.itens-pedido.obrigatorio}";

    Class<?>[] groups() default{} ;

    Class<? extends Payload>[] payload() default{};
}
