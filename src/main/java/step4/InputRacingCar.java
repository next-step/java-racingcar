package step4;

import java.util.Scanner;

public class InputRacingCar {
    private static final Scanner scanner = new Scanner(System.in);

    public String[] inputNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");

        return splitNames();
    }

    public int inputTimes() {
        System.out.println("시도할 회수는 몇회인가요?");
        return scanner.nextInt();
    }

    private static String[] splitNames() {
        return scanner.next().split(",");
    }

}
