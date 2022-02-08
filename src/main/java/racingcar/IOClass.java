package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IOClass {

    private static final Scanner sc = new Scanner(System.in);

    public static Car[] inputName() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String namesString = sc.nextLine();
        namesString = namesString.replace(" ", "");
        String[] carNames = namesString.split(",");
        final int CARS_COUNT = carNames.length;
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < CARS_COUNT; i++) {
            cars[i] = new Car(carNames[i]);
        }

        return cars;
    }

    public static int getTimes() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        int times = sc.nextInt();
        return times;
    }

    public static void printCurrentPosition(Car[] cars) {
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            printfCarPosition(car);
            System.out.println();
        }
    }

    private static void printfCarPosition(Car car) {
        for (int j = 0; j < car.getPosition(); j++) {
            System.out.print("-");
        }
    }

    public static void printWinners(Car[] cars) {
        int maxScore = Race.getMaxScore(cars);
        System.out.print("최종 우승자: ");
        List<String> winnerNames = getWinnerNames(cars, maxScore);
        String.join(", ", winnerNames);
    }

    private static List<String> getWinnerNames(Car[] cars, int maxPosition) {
        List<String> winners = new ArrayList<>();
        final int CARS_COUNT = cars.length;
        for (int i = 0; i < CARS_COUNT; i++) {
            if (cars[i].isSamePosition(maxPosition)) {
                winners.add(cars[i].getName());
            }
        }
        return winners;
    }
}