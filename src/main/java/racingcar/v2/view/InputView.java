package racingcar.v2.view;

import racingcar.v1.dto.RacingGameParam;
import racingcar.v1.utils.validator.StringSizeValidator;
import racingcar.v1.utils.validator.StringToNumberValidator;
import racingcar.v1.utils.validator.Validator;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    private static final String PARTICIPANT_QUESTION = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String TRY_NUMBER_QUESTION = "시도할 회수는 몇 회 인가요?";

    public static String getCarNames() {
        System.out.println(PARTICIPANT_QUESTION);

        return scanner.nextLine();
    }

    public static int getTryNumber() {
        System.out.println(TRY_NUMBER_QUESTION);

        return scanner.nextInt();
    }

}
