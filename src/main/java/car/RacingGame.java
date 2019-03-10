package car;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RacingGame {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        int carCount = scanner.nextInt();

        System.out.println("시도할 회수는 몇 회 인가요?");
        int tryCount = scanner.nextInt();

        gameStart(carCount, tryCount);
    }

    private static void gameStart(int carCount, int tryCount) {
        List<Car> carList = setCarList(carCount);

        for( int i=0; i < tryCount; i++) {
            printCurrentStatus(move(carList));
            System.out.println();
        }
    }

    static List<Car> setCarList(int carCount) {
        List<Car> carList = new ArrayList<>();

        int i=0;
        while (i< carCount) {
            carList.add(new Car());
            i++;
        }

        return carList;
    }

    static List<Car> move(List<Car> carList) {
        Random random = new Random();
        int carCount = carList.size();

        for (Car aCarList : carList) {
            int randomValue = random.nextInt(10);
            aCarList.setStatus(randomValue);
        }

        return carList;
    }

    private static void printCurrentStatus(List<Car> carList) {
        int carCount = carList.size();

        for (Car aCarList : carList) {
            aCarList.printStatus();
        }
    }
}
