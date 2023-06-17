//package com.unicorn.todoList.validation;
//
//import com.unicorn.todoList.validation.DateInFuture;
//import org.springframework.stereotype.Component;
//
//import javax.validation.ConstraintValidator;
//        import javax.validation.ConstraintValidatorContext;
//        import java.time.LocalDate;
//        import java.util.Date;
//
//@Component
//public class FutureDateValidator implements ConstraintValidator<DateInFuture, LocalDate> {
//
//    @Override
//    public void initialize(DateInFuture constraintAnnotation) {}
//
//    @Override
//    public boolean isValid(LocalDate localDate, ConstraintValidatorContext context) {
//        if (localDate == null) {
//            return true; // not our responsibility to check null, use @NotNull for that
//        }
//        // convert Date to LocalDate
//       // LocalDate localDate = new java.sql.Date(date.getTime()).toLocalDate();
//        return localDate.isAfter(LocalDate.now()); // true if strictly future date
//    }
//}
