package com.spring.junit.exception.JunitExceptionHandlingProject.model;




public class PayloadValidation {

    public static boolean createdPayloadValidation(Employee employee){

        if(employee.getId()>0) return false;
        return true;
    }


}
