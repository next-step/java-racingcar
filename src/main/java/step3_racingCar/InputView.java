package step3_racingCar;

import java.util.ArrayList;
import java.util.Scanner;

public class InputView {
    private static Scanner sc;

    public static ArrayList<Integer> input(String[] strArr){
        sc = new Scanner(System.in);
        ArrayList<Integer> input = new ArrayList<>();
        for(String str: strArr) {
            System.out.println(str);
            input.add(sc.nextInt());
        }
        sc.close();
        return input;
    }
}
