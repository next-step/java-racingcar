package step5.view;

import org.apache.commons.lang3.math.NumberUtils;
import step5.Controller;
import step5.domain.InputValue;

/**
 * Created By mand2 on 2020-11-04.
 */
public class InputView {
    private final static String CAR_NUMBER = "자동차 대수는 몇 대 인가요?";
    private final static String ROUND_NUMBER = "시도할 회수는 몇 회 인가요?";
    private final static String CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";

    public static InputValue askQuestions() {
        return new InputValue(askCarNames(), askRoundNumber());
    }

    private static String askCarNames() {
        System.out.println(CAR_NAMES);
        return Controller.SCANNER.nextLine();
    }

    private static int askRoundNumber() {
        System.out.println(ROUND_NUMBER);
        String rounds = Controller.SCANNER.nextLine();
        return NumberUtils.toInt(rounds);
    }

}
