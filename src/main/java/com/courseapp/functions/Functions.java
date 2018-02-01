package com.courseapp.functions;

import org.apache.commons.validator.routines.EmailValidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Functions {

    private static boolean validateEmail(String email){
       return EmailValidator.getInstance().isValid(email);

    }

    public static String validStudentParams(String name,String surname,String email,String dob,Long teacherId){
        name=name.trim();
        surname=surname.trim();
        dob=dob.trim();
        if(!email.isEmpty() && !validateEmail(email)){
            return "Email is invalid";
        }else if(teacherId.equals(0l)){
            return "Dont selected teacher";
        }else if(name.isEmpty() || surname.isEmpty() || dob.isEmpty()){
            return "Student name or Student surname or Student birth date is empty";
        }else if(!validateNameOrSurname(name) || !validateNameOrSurname(surname)){
            return "Student name or Student surname is invalid";
        }else {
            return "Ok";
        }
    }


    private static boolean validateNameOrSurname(String nameOrSurname){
        Pattern pattern =Pattern.compile("^[a-z A-Z']{3,15}$");
        Matcher matcher=pattern.matcher(nameOrSurname);
        boolean matches = matcher.matches();
        return matches;
    }
}
