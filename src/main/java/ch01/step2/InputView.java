package ch01.step2;

import java.util.Scanner;

public class InputView {

    InputData inputData;

    public InputData getInputData() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        Scanner sc = new Scanner(System.in);
        int carCount = sc.nextInt();

        System.out.println("시도할 회수는 몇 회 인가요?");
        int attemptCount = sc.nextInt();
        return new InputData(carCount,attemptCount);
    }
}
