package step3.view;

import java.util.Scanner;

public class InputView {
    public static final Scanner SCANNER = new Scanner(System.in);
    public static final String INPUT_NUM_CAR = "자동차 대수는 몇 대 인가요?";
    public static final String INPUT_NUM_TRY = "시도할 회수는 몇 회 인가요?";

    public int getNumCar() {
        System.out.println(INPUT_NUM_CAR);
        int numCar = SCANNER.nextInt();
        isPositiveNum(numCar);
        return numCar;
    }

    public int getNumTry() {
        System.out.println(INPUT_NUM_TRY);
        int numTry = SCANNER.nextInt();
        isPositiveNum(numTry);
        return numTry;
    }

    public void isPositiveNum(int value) {
        if (value <= 0) {
            throw new IllegalArgumentException("0 이거나 음수는 허용되지 않습니다.");
        }
    }
}
