package racingcar.racing;

public class RacingCar {
    int id;
    int progress;

    public RacingCar(int id, int progress) {
        this.id = id;
        this.progress = progress;
    }

    public int getId() {
        return this.id;
    }

    public void setProgress() {
        progress += 1;
    }

    public int getProgress() {
        return this.progress;
    }
}
