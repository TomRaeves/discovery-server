package com.company.namingserver;

public class Hasher {

    public static int hashCode(String input){
        long max = 2147483647;
        long min = -2147483647;

        double result = ((input.hashCode()+max)*32768d)/(max+Math.abs(min));

        //double result = (IP.hashCode() + hostname.hashCode()+max)*(32768d/(max+abs(min)));
        //Eventueel hash maken over naam EN IP zodat je telkens een verschillende ID hebt
        
        return (int) result;
    }
}


