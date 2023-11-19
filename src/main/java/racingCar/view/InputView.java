package racingCar.view;

import java.util.Scanner;

public class InputView {

    private InputView(){}

    public static int[] input() {
        int[] inputValues = new int[2];

        Scanner scanner = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        inputValues[0] = scanner.nextInt();

        System.out.println("시도할 횟수는 몇 회 인가요?");
        inputValues[1] = scanner.nextInt();

        return inputValues;
    }
}
