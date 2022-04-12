package racingcar.model;

public class TrialCount {

    private int finalTrialCont;

    private int nowTrialCount = 0;

    public TrialCount(int finalTrialCount) {
        this.finalTrialCont = finalTrialCount;
    }

    public boolean hasNextTrial() {
        return nowTrialCount < finalTrialCont;
    }

    public void increaseNextTrial() {
        this.nowTrialCount += 1;
    }

}
