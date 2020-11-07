package racingcar;

import java.util.Scanner;

public class Admin {
    public static void InputCarCount(){
        Game.setCars(Integer.parseInt(new Scanner(System.in).nextLine()));
    }

    public static void InputRoundCount(){
        Game.setRoundCount(Integer.parseInt(new Scanner(System.in).nextLine()));
    }
}
