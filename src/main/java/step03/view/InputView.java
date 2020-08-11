package step03.view;

import step03.calculatescore.CalculatorRandomScore;
import step03.calculatescore.WinnerCalculate;
import step03.car.Car;
import step03.car.CarCenter;
import step03.game.CarRacingGame;
import step03.util.Util;

import java.util.List;
import java.util.Scanner;

/**
 * Project : java-racingcar
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 11:12 오후
 */
public class InputView {

    public static void main(String[] args) {
        final Scanner input = Util.input();

        System.out.println(Util.WHATYOURNAME);
        final String[] carName = input.nextLine().split(",");

        System.out.println(Util.HOWMUCHTRY);
        int tryNum = input.nextInt();
        System.out.println(Util.RESULT);

        final CarCenter carCenter = new CarCenter();
        final List<Car> cars = carCenter.makingCar(carName);

        final CarRacingGame carRacingGame = new CarRacingGame();
        carRacingGame.racing(tryNum, cars, new CalculatorRandomScore());

        final ResultView resultView = new ResultView();
        resultView.drawWinnerBoard(cars, new WinnerCalculate());
    }

}
