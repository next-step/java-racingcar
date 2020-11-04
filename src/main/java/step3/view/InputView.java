package step3.view;

import org.apache.commons.lang3.math.NumberUtils;
import step3.Controller;

/**
 * Created By mand2 on 2020-11-04.
 */
public class InputView {
    private final static String CAR_NUMBER = "자동차 대수는 몇 대 인가요?";
    private final static String ROUND_NUMBER = "시도할 회수는 몇 회 인가요?";

    public static int askCarNumber() {
        System.out.println(CAR_NUMBER);
        String participants = Controller.SCANNER.nextLine();
        return NumberUtils.toInt(participants);
    }

    public static int askRoundNumber() {
        System.out.println(ROUND_NUMBER);
        String rounds = Controller.SCANNER.nextLine();
        return NumberUtils.toInt(rounds);
    }

}
