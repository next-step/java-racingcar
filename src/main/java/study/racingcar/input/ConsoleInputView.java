package study.racingcar.input;

import study.racingcar.model.RacingGameInfo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by wyparks2@gmail.com on 2019-06-17
 * Blog : http://wyparks2.github.io
 * Github : http://github.com/wyparks2
 */
public class ConsoleInputView implements InputView {
    private static final String FIRST_QUESTION = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String SECOND_QUESTION = "시도할 회수는 몇 회 인가요?";
    private static final String SPLIT_REGEX = ",";

    @Override
    public RacingGameInfo questionAndAnswer() {
        Scanner scanner = new Scanner(System.in);

        System.out.println(FIRST_QUESTION);
        final String carNames = scanner.next();
        final Set<String> splitCarNames = new HashSet<>(Arrays.asList(carNames.split(SPLIT_REGEX)));

        System.out.println(SECOND_QUESTION);
        final int moveCarTryLimit = scanner.nextInt();

        return new RacingGameInfo(splitCarNames, moveCarTryLimit);
    }
}
