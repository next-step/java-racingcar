package racing.module;

import exception.CustomException;
import java.util.Scanner;

public class Input {
    private static final Scanner SCANNER = new Scanner(System.in);

    private Input() throws CustomException {
        throw new CustomException("유틸성 클래스입니다.");
    }

    public static int inputCar() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return SCANNER.nextInt();
    }

    public static int inputTrial() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return SCANNER.nextInt();
    }
}
