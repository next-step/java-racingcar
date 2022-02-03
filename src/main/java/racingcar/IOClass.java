package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IOClass {

    public static Car[] getName() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        str = str.replace(" ", "");
        String[] carNames = str.split(",");
        final int CARS_COUNT = carNames.length;
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < CARS_COUNT; i++) {
            cars[i] = new Car(carNames[i]);
        }

        return cars;
    }

    public static boolean checkCarName(Car[] cars) {
        final int CARS_COUNT = cars.length;
        for (int i = 0; i < CARS_COUNT; i++) {
            if (cars[i].getName().length() > 5) {
                return false;
            }
        }
        return true;
    }

    public static int getTimes() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        Scanner sc = new Scanner(System.in);
        int times = sc.nextInt();
        return times;
    }

    public static void printCurrentPosition(Car[] cars) {
        final int CARS_COUNT = cars.length;
        for (int i = 0; i < CARS_COUNT; i++) {
            System.out.print(cars[i].getName() + " : ");
            for (int j = 0; j < cars[i].getPosition(); j++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }

    public static void printWinners(Car[] cars) {
        int count = 0;
        int maxScore = Race.getMaxScore(cars);
        System.out.print("최종 우승자: ");
        List<String> winnerNames = getWinnerNames(cars, maxScore);
        final int WINNERS_COUNT = winnerNames.size();
        for (int i = 0; i < WINNERS_COUNT; i++) {
            if (count != 0) {
                System.out.print(", ");
            }
            System.out.print(winnerNames.get(i));
            count++;
        }
    }

    private static List<String> getWinnerNames(Car[] cars, int maxScore) {
        List<String> winners = new ArrayList<>();
        final int CARS_COUNT = cars.length;
        for (int i = 0; i < CARS_COUNT; i++) {
            if (cars[i].getPosition() == maxScore) {
                winners.add(cars[i].getName());
            }
        }
        return winners;
    }
}