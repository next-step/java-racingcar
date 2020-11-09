package racingcar;

import java.util.Scanner;

public class InputView {

    static Game game = new Game();

    public static void viewCountCarInput(){
        System.out.println("자동차 대수는 몇 대인가요?");
        game.setCars(Integer.parseInt(new Scanner(System.in).nextLine()));
        System.out.println(game.cars.getSize());
    }

    public static void viewCountRoundInput(){
        System.out.println("시도할 횟수는 몇 회인가요?");
        game.setRoundCount(Integer.parseInt(new Scanner(System.in).nextLine()));
        System.out.println(game.getRoundCount());
    }
}
