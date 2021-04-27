package jung;

import java.util.Scanner;

public class CarName {
    Scanner scann = new Scanner(System.in);
    String[] names;

    CarName() {
       names =  scann.next().replaceAll(" ", "").split(",");
    }

    String[] car() {
        return names;
    }
}
