package step3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {


    public static Racing createRacing() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        int carNumber = createIntNumber(scanner);
        System.out.println("시도할 횟수는 몇 회 인가여?");
        int tryNumber = createIntNumber(scanner);
        return new Racing(carNumber, tryNumber);
    }

    private static int createIntNumber(Scanner scanner) {
        try {
            int carNumber = scanner.nextInt();
            if (carNumber < 0) {
                throw new InputMismatchException();
            }
            return carNumber;
        } catch (InputMismatchException exception) {
            throw new InputMismatchException("양수의 숫자만 입력해주세요");
        }
    }
}
