package thirdstep.View;


import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputCarCount() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        try {
            return scanner.nextInt();
        }
        catch (InputMismatchException e) {
            System.out.println("정수값만 입력해 주세요.");
        }
        return 0;
    }

    public static int inputRaceCount() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        try {
            return scanner.nextInt();
        }
        catch (InputMismatchException e) {
            System.out.println("정수값만 입력해 주세요.");
        }
        return 0;
    }
}
