package step4;

import car.Car;

import java.util.List;

public class ResultView {
    private Racing racing;

    public ResultView(Racing racing) {
        this.racing = racing;
    }

    public void print() {
        this.racing.finish();
    }
}
