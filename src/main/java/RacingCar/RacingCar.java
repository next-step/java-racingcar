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
    ArrayList<Winner> winners = new ArrayList<Winner>();
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

        chooseWinners();
        output.printWinner(winners);

    }

    private void chooseWinners() {
        int maxLocation = 0;

        maxLocation = getMaxLocation(maxLocation);

        addWinner(maxLocation);

    }

    private void addWinner(int maxLocation) {
        for (Car car : cars)
            if (maxLocation == car.getLocation()) winners.add(new Winner(car.getName()));
    }

    private int getMaxLocation(int maxLocation) {
        for (Car car : cars)
            if (car.getLocation() > maxLocation) maxLocation = car.getLocation();
        return maxLocation;
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
