package racingcar;

import java.util.List;
import java.util.Scanner;

public class InputView {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요? ");
        int cars = scanner.nextInt();

        System.out.println("시도할 회수는 몇 회 인가요? ");
        int count = scanner.nextInt();

        RacingCar racingCar = new RacingCar(cars, count);
        List<Car> list = racingCar.settingCars(cars);
        racingCar.moveToN(list, count);
        racingCar.carStatus(list);

    }
}
