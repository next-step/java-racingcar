package race;

import race.ui.ResultView;

import java.util.Random;

public class Car {
    private final static String STEP_STRING = "-";
    private final StringBuffer step = new StringBuffer();

    public void go() {
        goOrStop();

        ResultView.print(step.toString());
    }

    private void goOrStop() {
        final int randomInt = new Random().nextInt(10);
        if (randomInt > 4) {
            this.step.append(STEP_STRING);
        }
    }
}
