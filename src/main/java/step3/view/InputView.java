package step3.view;

import step3.model.InputData;

import java.util.Scanner;

public class InputView {
    public static final Scanner SCANNER = new Scanner(System.in);
    public static final String INPUT_NUM_CAR = "자동차 대수는 몇 대 인가요?";
    public static final String INPUT_NUM_TRY = "시도할 회수는 몇 회 인가요?";

    public InputData inputData() {
        System.out.println(INPUT_NUM_CAR);
        int numCar = SCANNER.nextInt();
        System.out.println(INPUT_NUM_TRY);
        int numTry = SCANNER.nextInt();

        return new InputData(numCar, numTry);
    }
}
