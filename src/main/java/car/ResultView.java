package car;

public class ResultView {
    private CarRacing racing;

    public ResultView(CarRacing racing) {
        this.racing = racing;
    }

    public void print() {
        this.racing.finish();
    }
}
