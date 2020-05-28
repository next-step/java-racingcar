package camp.nextstep.edu.nextstep8.step3;

import java.util.Scanner;
import java.util.function.Function;

public class RacingGameInputView {
    public int getCarNumbers() {
        return getValueFromInputStream("참가할 자동차는 몇 대 인가요?", Scanner::nextInt);
    }

    public int getRoundTimes() {
        return getValueFromInputStream("시도할 횟수는 몇 회 인가요?", Scanner::nextInt);
    }

    private <R> R getValueFromInputStream(String inputGuideMessage, Function<Scanner, R> resolver) {
        final Scanner scanner = new Scanner(System.in);
        System.out.print (inputGuideMessage + "\t: " );
        return resolver.apply(scanner);
    }
}
