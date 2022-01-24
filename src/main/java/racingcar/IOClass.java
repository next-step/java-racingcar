package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class IOClass {

    public static Car[] getName() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        str = str.replace(" ", "");
        String[] carNames = str.split(",");
        Car[] cars = new Car[carNames.length];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(carNames[i]);
        }

        return cars;
    }

    public static boolean checkCarName(Car[] cars) {
        for (int i = 0; i < cars.length; i++) {
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
        for (int i = 0; i < cars.length; i++) {
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
        ArrayList<String> winnerNames = getWinnerNames(cars, maxScore);
        for (int i = 0; i < winnerNames.size(); i++) {
            if (count != 0) {
                System.out.print(", ");
            }
            System.out.print(winnerNames.get(i));
            count++;
        }
    }

    static ArrayList<String> getWinnerNames(Car[] cars, int maxScore) {
        ArrayList<String> winners = new ArrayList<>();
        for (int i = 0; i < cars.length; i++) {
            if (cars[i].getPosition() == maxScore) {
                winners.add(cars[i].getName());
            }
        }
        return winners;
    }
}