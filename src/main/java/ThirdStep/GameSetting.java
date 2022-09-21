package ThirdStep;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameSetting {
    private static int carCount;
    private static int attempts;

    public static int getCarCount() {
        return carCount;
    }

    public static int getAttempts() {
        return attempts;
    }

    public static void setting() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");
        carCount = scanner.nextInt();

        System.out.println("시도할 회수는 몇 회 인가요?");
        attempts = scanner.nextInt();
    }

    public static List<Car> getCars() {
        List<Car> cars = new ArrayList<>();
        for (int count = 0 ; count < GameSetting.getCarCount() ; ++count) {
            cars.add(new Car());
        }

        return cars;
    }
}
