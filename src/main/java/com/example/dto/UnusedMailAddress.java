//package com.example.dto;
//
//import static java.lang.annotation.ElementType.*;
//import static java.lang.annotation.RetentionPolicy.*;
//
//import java.lang.annotation.Documented;
//import java.lang.annotation.Retention;
//import java.lang.annotation.Target;
//
//import jakarta.validation.Constraint;
//import jakarta.validation.Payload;
//
//
//@Documented
//@Constraint(validatedBy = {UnusedMailAddressValidator.class})
//@Target({FIELD})
//@Retention(RUNTIME)
//public @interface UnusedMailAddress {
//
//    String message() default "このメールアドレスは既に登録されています";
//    Class<?>[] groups() default {};
//    Class<? extends Payload>[] payload() default {};
//    
//    @Target({FIELD})
//    @Retention(RUNTIME)
//    @Documented
//    public @interface List {
//        UnusedMailAddress[] value();
//    }
//}