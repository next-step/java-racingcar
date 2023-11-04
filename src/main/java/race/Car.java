package race;

import race.ui.ResultView;

import java.util.Random;

public class Car {
    private int step = 0;

    public void go(final int raceAttemptCount) {
        this.step = 0;

        for (int i = 0; i < raceAttemptCount; i ++) {
            goOrStop();
        }
    }

    private void goOrStop() {
        final int randomInt = new Random().nextInt(10);
        if (randomInt > 4) {
            this.step++;
        }
    }

    public boolean isStepArrive(final int i) {
        return step >= i;
    }

    public void print(final int currentStep) {
        if (isStepArrive(currentStep)) {
            ResultView.print(currentStep);
            return;
        }

        ResultView.print(step);
    }
}
