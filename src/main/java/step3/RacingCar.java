package step3;

import static step3.InputView.inputCountCar;
import static step3.InputView.inputTryCount;
import static step3.ResultView.printGoDistance;
import static step3.ResultView.printResultMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingCar {
    private static final int RANDOM_SIZE = 10;

    public static void main(String[] args) {
        startRacing();
    }

    public static void startRacing() {
        Race race = new Race(makeRacingCar(inputCountCar()), makeTryCount(inputTryCount()));
        getGameResult(race);
    }

    private static List<Car> makeRacingCar(int carCount) {
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            carList.add(new Car());
        }
        return carList;
    }

    private static int makeTryCount(int tryCount) {
        return tryCount;
    }

    private static void getGameResult(Race race) {
        printResultMessage();
        for (int i = 0; i < race.getTryCount(); i++) {
            carMove(race.getCarList());
        }
    }

    private static void carMove(List<Car> carList) {
        for (int i = 0; i < carList.size(); i++) {
            carList.get(i).goCar(getRandomNum());
            printMove(carList);
            System.out.println();
        }
    }

    private static int getRandomNum() {
        Random random = new Random();
        return random.nextInt(RANDOM_SIZE);
    }

    public static void printMove(List<Car> carList) {
        for (Car car : carList) {
            printGoDistance(car.getDistance());
        }
    }
}
