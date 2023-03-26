package racing;

import racing.view.InputView;
import racing.view.OutputView;

import java.util.Random;


public class TheGame {

    public static Random random;
    public Car[] cars;
    public int round;

    public TheGame(String names, int round) {
        this.cars = initCars(names);
        this.round = round;
        this.random = new Random();
    }

    public static void main(String[] args) {

        //모델분리 InputView
        InputView inputView = new InputView();

        String names = inputView.inputCarname();
        int round = inputView.inputRound();


        TheGame TheGame = new TheGame(names, round);

        //모델분리 OutputView
        OutputView outputView = new OutputView();
        String winner = outputView.winnerCar(round, TheGame.cars);
        System.out.println("우승자: " + winner);


    }

    public Car[] initCars(String names) {
        String[] nameArray = names.split(",");
        Car[] cars = new Car[nameArray.length];

        for (int i = 0; i < nameArray.length; i++) {
            cars[i] = new Car(nameArray[i]);
        }

        return cars;
    }


}