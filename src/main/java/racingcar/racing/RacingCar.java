package racingcar.racing;

public class RacingCar {
    private final int id;
    private int progress;

    public RacingCar(int id, int progress) {
        this.id = id;
        this.progress = progress;
    }

    public int getId() {
        return this.id;
    }

    public void setProgress(int result) {
        progress = result;
    }

    public int getProgress() {
        return this.progress;
    }
}
