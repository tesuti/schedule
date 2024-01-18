//package com.example.dto;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//import com.example.model.User;
//
//import jakarta.validation.ConstraintValidator;
//import jakarta.validation.ConstraintValidatorContext;
//
//public class UnusedMailAddressValidator implements ConstraintValidator<UnusedMailAddress, String> {
//    @Autowired
//    UserDao userDao;
//    
//	@Override
//	    public void initialize(UnusedMailAddress constraintAnnotation) {
//	    }
//
//	    @Override
//	    public boolean isValid(String value, ConstraintValidatorContext context) {
//	        
//	    	User user = userDao.findByEmail(value);
//	        if(user!=null) {
//	            return false;
//	        }
//	        
//	        return true;
//	    }
//}
