package step03.view;

import step03.game.CarRacingGame;
import step03.util.Util;
import step03.calculatescore.CalculatorRandomScore;
import step03.car.Car;
import step03.car.CarCenter;

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
        Scanner input = Util.input();

        System.out.println(Util.howManyCars);
        int carNum = input.nextInt();

        System.out.println(Util.howMuchTry);
        int tryNum = input.nextInt();
        System.out.println(Util.result);

        InputView inputView = new InputView();

        CarCenter carCenter = new CarCenter();
        List<Car> cars = carCenter.makingCar(carNum);

        CarRacingGame carRacingGame = new CarRacingGame();
        while (tryNum-- > 0) {
            carRacingGame.racing(cars, new CalculatorRandomScore());
        }


    }

}
