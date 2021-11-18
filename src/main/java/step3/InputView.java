package step3;

import java.util.Scanner;

public class InputView {

    public static void viewCountCarInputMessage(){
        System.out.println("자동차 대수는 몇 대인가요?");
    }

/*    public static void viewCountCarInput(){
        Cars.createCars(Integer.parseInt(new Scanner(System.in).nextLine()));
    }*/

    public static void viewCountCar(){
        System.out.println(Game.cars.getSize());
    }

    public static void viewCountRoundInputMessage(){
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public static void viewCountRoundInput(){
        Game.roundCount = Integer.parseInt(new Scanner(System.in).nextLine());
    }

    public static void viewCountRound(){
        System.out.println(Game.getRoundCount());
    }
}