package racingcar.view;

import racingcar.Car;
import racingcar.RacingCar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("자동차 대수는 몇 대 인가요?");
        int carCount = scanner.nextInt();

        System.out.println("시도할 회수는 몇 회 인가요?");
        int round = scanner.nextInt();

        new RacingCar(loader(carCount), round, new ResultView()).playRacing();
    }

    private static List<Car> loader(int carCount) {

        List<Car> cars = new ArrayList<>();
        for (int number = 0; number < carCount; number++) {
            cars.add(new Car());
        }

        return cars;
    }
}
