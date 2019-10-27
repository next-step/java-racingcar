package step2;

import java.io.PrintStream;
import java.util.Scanner;

public class StandardInputView implements InputView {
    private final String guideMessageToInputNumberOfCars;
    private final String guideMessageToInputNumberOfTryTimes;

    private final Scanner in = new Scanner(System.in);
    private final PrintStream out = System.out;

    public StandardInputView() {
        this.guideMessageToInputNumberOfCars = "자동차 대수는 몇 대 인가요?";
        this.guideMessageToInputNumberOfTryTimes = "시도할 회수는 몇 회 인가요?";
    }

    public StandardInputView(final String guideMessageToInputNumberOfCars,
                             final String guideMessageToInputNumberOfTryTimes) {
        this.guideMessageToInputNumberOfCars = guideMessageToInputNumberOfCars;
        this.guideMessageToInputNumberOfTryTimes = guideMessageToInputNumberOfTryTimes;
    }

    @Override
    public GameRunner makeGameRunner() {
        out.println(guideMessageToInputNumberOfCars);
        final int numberOfCars = in.nextInt();

        out.println(guideMessageToInputNumberOfTryTimes);
        final int numberOfTryTimes = in.nextInt();

        return GameRunner.builder()
                         .tryTimes(numberOfTryTimes)
                         .numberOfCars(numberOfCars)
                         .carDistanceGenerator(new RandomCarDistanceGenerator())
                         .build();
    }
}
