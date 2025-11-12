package racingGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);

    public int racingCars() {
        System.out.print("자동차 대수는 몇 대 인가요? ");
        return scanner.nextInt();
    }

    public int rounds() {
        System.out.print("시도할 회수는 몇 회 인가요? ");
        return scanner.nextInt();
    }

    public List<Car> getCarList(int count) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            cars.add(new Car("car_" + (i + 1), 0));
        }
        return cars;
    }
}
