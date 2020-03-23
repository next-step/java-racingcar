package racingcar;

import java.util.Scanner;

public class InputView {

    private InputData inputData;
    private Scanner scanner;

    public InputView() {
        scanner = new Scanner(System.in);
    }

    public void input() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        int numberOfCars = scanner.nextInt();

        System.out.println("시도할 횟수는 몇 회 인가요?");
        int tryCount = scanner.nextInt();

        inputData = new InputData(numberOfCars, tryCount);
    }

    public InputData getInputData() {
        return inputData;
    }
}
