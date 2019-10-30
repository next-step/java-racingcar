package study.firstweek.secondstep;

import java.util.ArrayList;

public class RacingCar {

    private int step = 1;
    private ArrayList<Integer> stepHistory = new ArrayList<>();

    public RacingCar() {
        stepHistory.add(step);
    }

    public ArrayList<Integer> getStepHistory() {
        return stepHistory;
    }

    public void makeCarMove(int number) {
        if (number >= 4) {
            addStep();
        }
        stepHistory.add(step);
    }

    private void addStep() {
        this.step++;
    }
}
