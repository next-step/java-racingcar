package car;

public class ResultView {
    private CarRacingGame racing;

    public ResultView(CarRacingGame racing) {
        this.racing = racing;
    }

    public void print() {
        this.racing.finish();
    }
}
