package jung;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CarName {
    Scanner scann = new Scanner(System.in);
    String error;
    ArrayList<String> arr;
    String[] names;



    boolean isCarLength(String[] namess) {
        for (String name : namess) {
            if (name.length() >= 5) {
                return false;
            }
        }
        return true;
    }


    String[] car_name() {
        boolean isWhile = true;

        while (isWhile) {
            names = scann.next().replaceAll(" ", "").split(",");
            if (isCarLength(names)) {
                isWhile=false;
            }
        }
        return names;
    }
}
