package RacingCar;

import RacingCar.Input.Input;
import RacingCar.Input.InputView;
import RacingCar.Output.Output;
import RacingCar.Output.ResultView;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class RacingCar {

    int carNumber;
    int count;
    ArrayList<Car> cars = new ArrayList<Car>();

    public static void start() {

        Input input = new Input();
        RacingCar racingCar = new RacingCar();
        racingCar.carNumber = input.InputCarNumber();
        racingCar.count = input.InputTryCount();
        racingCar.addCar();
        racingCar.result();


    }

    private void addCar() {

        for (int i = 0; i < carNumber; i++)
            cars.add(new Car("-", 4));

    }

    private void result() {

        Output output = new Output();
        output.Output();

        for (int i = 0; i < count; i++) {
            moveCar();
            showLoaction();
            System.out.println("");
        }
    }

    private void moveCar() {

        for (Car car : cars)
            car.move(getRandomNumber(10));
    }

    private void showLoaction() {
        for (Car car : cars)
            System.out.println(car.location());
    }

    private static int getRandomNumber(int num) {

        Random random = new Random();
        int result = random.nextInt(num);

        return result;
    }

}
