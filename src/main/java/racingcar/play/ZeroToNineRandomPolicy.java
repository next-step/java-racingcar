package racingcar.play;
import racingcar.racing.RacingCar;
import java.util.Random;

public class ZeroToNineRandomPolicy implements RacingGamePolicy {

    private static final Random random = new Random();
    private static final int FORWARD_CONDITION = 4;

    @Override
    public RacingCar racing(RacingCar racingCar, int tryNumber, int value) {
        for (int i = 0; i < tryNumber; i++) {
            forward(racingCar, random.nextInt(value));
        }

        return racingCar;
    }

    private void forward(RacingCar racingCar, int value) {
        if (value > FORWARD_CONDITION) {
            racingCar.setProgress();
        }
    }
}
