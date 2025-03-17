package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static final int MOVABLE_THRESHOLD = 4;
    public static final int DEFAULT_MOVING_DISTANCE = 1;
    public static final int RANDOM_BOUND = 10;
    public static final String DEFAULT_MARKER = "-";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");
        int carCount = scanner.nextInt();
        System.out.println("시도할 회수는 몇 회 인가요?");
        int attempts = scanner.nextInt();
        System.out.println("\n실행 결과");

        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car(MOVABLE_THRESHOLD));
        }

        Random random = new Random();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < attempts; i++) {
            for (Car car : cars) {
                int randomInt = random.nextInt(RANDOM_BOUND);
                car.moveOrStop(randomInt, DEFAULT_MOVING_DISTANCE);
                String trace = car.getTrace(DEFAULT_MARKER);
                if (trace.isBlank()) {
                    trace = " ";
                }
                result.append(trace).append("\n");
            }
            System.out.println(result);
            System.out.println();
        }

    }
}
