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
    ArrayList<Car> winners = new ArrayList<Car>();
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
            for (Car car : cars) car.move(getRandomNumber(10));

            showLoaction();
            output.printSpace();

        }

        for (Car car : cars) {
            addWinner(car, car.chooseWinner(cars));

        }

        output.printWinner(winners);

    }

    public void addWinner(Car car, String winnerName) {
        if (!winnerName.isEmpty())
            winners.add(new Car(car.getLocation(), winnerName));
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


}
