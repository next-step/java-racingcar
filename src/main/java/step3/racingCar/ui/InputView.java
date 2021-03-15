package step3.racingCar.ui;

import step3.racingCar.Game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static Scanner sc;
    private static List<Object> input = new ArrayList<>();

    public static List<Object> input(String[] strArr) {
        sc = new Scanner(System.in);
        for (String str : strArr) {
            System.out.println(str);
            checkInput(str);
        }
        sc.close();
        return input;
    }

    public static void checkInput(String str){
        if(str.equals(Game.HOW_MANY_CARS) || str.equals(Game.HOW_MANY_TRYS)){
            input.add(sc.nextInt());
        }
        if(str.equals(Game.INPUT_CAR_NAMES)){
            input.add(sc.nextLine());
        }
    }
}
