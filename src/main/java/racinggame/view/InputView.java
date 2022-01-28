

package racinggame.view;

import java.util.Scanner;
import racinggame.domain.Validator;
import racinggame.service.InputService;

public class InputView {

    public static final String QUIT = "q";

    public InputView() {}

    public String inputCarNames() {
        System.out.printf("경주할 자동차 이름을 %s로 구분해서 입력하세요.(%d대 이상)\n", InputService.SEPARATOR,
                Validator.MINIMUM_PLAYER);
        return getInput();
    }

    public String inputTrial() {
        System.out.print("시도 횟수를 입력해 주세요: ");
        return getInput();
    }

    public String inputRestartCommand() {
        System.out.printf("게임이 종료되었습니다. (종료 = %s, 다시 시작 = 아무 키 입력)\n", QUIT);
        return getInput();
    }

    private static String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}