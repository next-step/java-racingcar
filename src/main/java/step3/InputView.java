package step3;

import java.util.Scanner;

public class InputView {

    Game game = new Game(5);

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

}