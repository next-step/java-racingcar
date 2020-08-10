package step03.view;

import step03.calculatescore.CalculatorRandomScore;
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
        Scanner input = Util.input();

        System.out.println(Util.WHATYOURNAME);
        String[] carName = input.nextLine().split(",");
        for (int i = 0; i< carName.length; i++) {
            System.out.println(carName[i]);
        }

//        System.out.println(Util.HOWMANYCAR);
//        int carNum = input.nextInt();

        System.out.println(Util.HOWMUCHTRY);
        int tryNum = input.nextInt();
        System.out.println(Util.RESULT);

        InputView inputView = new InputView();

        CarCenter carCenter = new CarCenter();
        List<Car> cars = carCenter.makingCar(carName);
        //List<Car> cars = carCenter.makingCar(carNum);

        CarRacingGame carRacingGame = new CarRacingGame();
        while (tryNum-- > 0) {
            carRacingGame.racing(cars, new CalculatorRandomScore());
        }


    }

}
