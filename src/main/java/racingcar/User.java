package racingcar;

import java.util.Scanner;

public class User {
    public static void InputCarCount(){
        Game.setCars(new Scanner(System.in).nextInt());
    }

    public static void InputRoundCount(){
        Game.setRoundCount(new Scanner(System.in).nextInt());
    }
}
