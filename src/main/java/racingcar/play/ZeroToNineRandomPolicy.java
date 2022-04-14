package racingcar.play;
import racingcar.racing.NumberGenerator;


public class ZeroToNineRandomPolicy implements RacingGamePolicy {

    private static final int FORWARD_CONDITION = 4;

    @Override
    public int racing(int progress, int value) {
        NumberGenerator numberGenerator = new NumberGenerator(value);

        return forward(progress, numberGenerator.generateNumber());
    }


    private int forward(int progress, int value) {
        if (value > FORWARD_CONDITION) {
           progress += 1;
        }

        return progress;
    }
}
