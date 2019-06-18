package study.racingcar.input;

import study.racingcar.model.RacingGameInfo;

import java.util.Scanner;

/**
 * Created by wyparks2@gmail.com on 2019-06-17
 * Blog : http://wyparks2.github.io
 * Github : http://github.com/wyparks2
 */
public class ConsoleInputView implements InputView {
    private static final String FIRST_QUESTION = "자동차 대수는 몇 대 인가요?";
    private static final String SECOND_QUESTION = "시도할 회수는 몇 회 인가요?";

    @Override
    public RacingGameInfo questionAndAnswer() {
        Scanner scanner = new Scanner(System.in);

        System.out.println(FIRST_QUESTION);
        int countOfRacingCar = scanner.nextInt();

        System.out.println(SECOND_QUESTION);
        int moveCarTryLimit = scanner.nextInt();

        return new RacingGameInfo(countOfRacingCar, moveCarTryLimit);
    }
}
