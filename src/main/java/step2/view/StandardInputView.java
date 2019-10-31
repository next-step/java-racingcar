package step2.view;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import step2.domain.GameRunner;
import step2.domain.RandomCarDistanceGenerator;

public class StandardInputView implements InputView {
    private static final String CAR_NAME_DELIMITER = ",";

    private final String guideMessageToInputNumberOfTryTimes;
    private final String guideMessageToInputCarNames;

    private final Scanner in = new Scanner(System.in);
    private final PrintStream out = System.out;

    public StandardInputView() {
        this.guideMessageToInputNumberOfTryTimes = "시도할 회수는 몇회인가요?";
        this.guideMessageToInputCarNames = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    }

    @Override
    public GameRunner makeGameRunner() {
        out.println(guideMessageToInputCarNames);
        final String rawCarNames = in.nextLine();

        out.println(guideMessageToInputNumberOfTryTimes);
        final int numberOfTryTimes = in.nextInt();

        return GameRunner.builder()
                         .tryTimes(numberOfTryTimes)
                         .carNames(splitToCarList(rawCarNames))
                         .carDistanceGenerator(new RandomCarDistanceGenerator())
                         .build();
    }

    private List<String> splitToCarList(final String carNames) {
        return Arrays.asList(carNames.split(CAR_NAME_DELIMITER));
    }
}
