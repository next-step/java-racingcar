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

    int count;
    ArrayList<Car> cars = new ArrayList<Car>();
    static Input input = new Input();
    Output output = new Output();

    public static void start() {
        RacingCar racingCar = new RacingCar();
        racingCar.addCar(input.splitCarName(","));
        racingCar.count = input.InputTryCount();
        racingCar.result();
    }

    private void addCar(String[] carName) {
        for (int i = 0; i < carName.length; i++)
            cars.add(new Car(1, carName[i]));
    }

    private void result() {
        output.Output();

        for (int i = 0; i < count; i++) {
            moveCar();
            showLoaction();
            output.printSpace();
        }
    }

    private void moveCar() {
        for (Car car : cars)
            if (checkCarMove(4, getRandomNumber(10))) car.setLocation(car.getLocation() + 1);

    }

    private void showLoaction() {
        for (Car car : cars)
            output.location(car.getName(), car.getLocation());
    }

    private static int getRandomNumber(int num) {
        Random random = new Random();
        int result = random.nextInt(num);

        return result;
    }

    private static boolean checkCarMove(int minNum, int randomNum) {
        if (randomNum >= minNum) return true;

        return false;
    }

}
