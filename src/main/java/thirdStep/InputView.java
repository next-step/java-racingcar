package thirdStep;

import java.util.Scanner;

public class InputView {
    Scanner scanner = new Scanner(System.in);

    public int inputCarCount() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        int carNumber = scanner.nextInt();
        return carNumber;
    }

    public int inputRaceCount() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        int raceCount = scanner.nextInt();
        return raceCount;
    }
}