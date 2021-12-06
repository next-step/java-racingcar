package step3;

import java.util.Scanner;

import static step3.Game.cars;

public class InputScanner {


    public static void main(String[] args){
        InputView inputView = new InputView();


        System.out.println("자동차 대수는 몇 대 인가요?");
        int carCount = Integer.parseInt(new Scanner(System.in).nextLine());
        System.out.println("시도할 회수는 몇 회 인가요?");
        int roundCount = Integer.parseInt(new Scanner(System.in).nextLine());
        Game game = new Game(roundCount);
        inputView.viewCountCarInputMessage();
        cars.createCars(carCount);


        inputView.viewCountCar();
        inputView.viewCountRoundInputMessage();
        inputView.viewCountRound();

        ResultView.viewResultMessage();


        game.execround(roundCount);
    }
}
