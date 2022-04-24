package racingcar.view;


import racingcar.racing.dto.RacingGameParam;
import racingcar.validator.StringSizeValidator;
import racingcar.validator.StringToNumberValidator;
import racingcar.validator.Validator;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    private static final String CAR_NUMBER_QUESTION = "자동차 대수는 몇 대 인가요?";
    private static final String PARTICIPANT_QUESTION = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String TRY_NUMBER_QUESTION = "시도할 회수는 몇 회 인가요?";

    private static final Validator<Integer, String> numberValidator = new StringToNumberValidator();

    private static final Validator<String[], String> stringValidator = new StringSizeValidator();

    public static RacingGameParam enterParam() {
        String[] names = stringValidator.valid(enterParticipant());

        int tryNumber = numberValidator.valid(enterTheNumberOfTry());

        return new RacingGameParam(names.length, tryNumber, names);
    }

    private static String enterParticipant() {
        System.out.println(PARTICIPANT_QUESTION);

        return scanner.nextLine();
    }

    private static String enterTheNumberOfCars() {
        System.out.println(CAR_NUMBER_QUESTION);

        return scanner.nextLine();
    }

    private static String enterTheNumberOfTry() {
        System.out.println(TRY_NUMBER_QUESTION);

        return scanner.nextLine();
    }

}
