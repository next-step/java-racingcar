package racingcar.game;

public class Trial {
    private int trial;

    public Trial(int trial) {
        this.trial = trial;
    }

    public void decrease() {
        this.trial--;
    }

    public boolean hasChance() {
        return this.trial > 0;
    }
}
