package racing.view;

import exception.CustomException;
import java.util.Scanner;

public final class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() throws CustomException {
        throw new CustomException("유틸성클래스는 인스턴스 생성을 할 수 없습니다.");
    }

    public static String inputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return SCANNER.nextLine();
    }

    public static int inputTrial() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return SCANNER.nextInt();
    }
}
