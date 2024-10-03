package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RacingGame {
    public static List<Car> cars = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("자동차 대수는 몇 대 인가요?");
        Scanner scanner = new Scanner(System.in);
        int carCount = scanner.nextInt();

        System.out.println("시도할 회수는 몇 회 인가요?");
        int racingCount = scanner.nextInt();

        System.out.println("실행 결과");
        run(carCount, racingCount);
    }

    private static void run(int carCount, int racingCount) {
        for (int i = 0; i < carCount; i++) {
            Car car = new Car();
            cars.add(car);
        }

        for (int i = 0; i < racingCount; i++) {
            for (Car car : cars) {
                Movement movement = new Movement();
                car.move(movement.isMove());
            }
            ResultView.printResult();
        }
    }
}
