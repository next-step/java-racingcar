package step3;

import java.util.Scanner;

public class InputView {

    ValidationCheck validationCheckCheck = new ValidationCheck();
    Scanner sc = new Scanner(System.in);

    public int inputCarNumber() {
        System.out.println("자동차 대수는 몇대 인가요?");
        int carNumber = sc.nextInt();
        validationCheckCheck.checkInputCarNumber(carNumber);
        return carNumber;
    }

    public int inputTryCount() {
        System.out.println("시도할 횟수는 몇 회 인가요?");
        int tryCount = sc.nextInt();
        validationCheckCheck.checkInputTryCount(tryCount);
        return tryCount;
    }
}
