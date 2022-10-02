package step4;

import java.util.Scanner;

public class InputRacingCar {
    private static Scanner scanner = new Scanner(System.in);
    public Car input() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String[] names = inputNames();

        System.out.println("시도할 회수는 몇회인가요?");
        int times = inputTimes();

        return new Car(names, times);
    }

    private static String[] inputNames() {
        return scanner.next().split(",");
    }

    private static int inputTimes() {
        return scanner.nextInt();
    }
}
