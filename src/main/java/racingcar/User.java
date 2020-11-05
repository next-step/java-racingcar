package racingcar;

import java.util.Scanner;

public class User {
    public static void InputCarCount(){
        Game.setCars(Integer.parseInt(new Scanner(System.in).nextLine()));
    }

    public static void InputRoundCount(){
        Game.setRoundCount(Integer.parseInt(new Scanner(System.in).nextLine()));
    }
}
