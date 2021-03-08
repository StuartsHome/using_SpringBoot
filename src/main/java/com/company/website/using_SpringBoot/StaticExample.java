package com.company.website.using_SpringBoot;

public class StaticExample {
    
}


class Geek {
    public static String geekName = "";

    public static void geeker(String name) {
        geekName = name;
    }
}

class GFG {
    public static void main(String[] args) {

        // Accessing the static method geeker()
        // and field by class name itself
        Geek.geeker("Stuart");
        System.out.println(Geek.geekName);

        // Accessing the static method geeker()
        // by using the object's reference
        Geek obj = new Geek();
        obj.geeker("David");
        System.out.println(obj.geekName);


    }

}
