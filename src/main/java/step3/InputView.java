package step3;

import java.util.Scanner;

public class InputView {

    Game game = new Game(5);

    public static int carCount;
    public static int roundCount;

    public void viewCountCarInputMessage(){
        System.out.println("자동차 대수는 몇 대인가요?");
    }

    public void viewCountCar(){
        System.out.println(Game.cars.getSize());
    }

    public void viewCountRoundInputMessage(){
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public void viewCountRound(){
        System.out.println(game.getRoundCount());
    }

    public static int inputScanner(){
        return Integer.parseInt(new Scanner(System.in).nextLine());
    }

    public static void inputScanUn(){
        System.out.println("자동차 대수는 몇 대 인가요?");
        carCount = inputScanner();
        System.out.println("시도할 회수는 몇 회 인가요?");
        roundCount = inputScanner();
    }

}