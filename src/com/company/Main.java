package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        StringList list = new MyStringList();
        list.add("1");
        list.add("2");
        list.add("5");
        list.add("4");
        list.add("5");

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.lastIndexOf("7"));
        }

    }


}
