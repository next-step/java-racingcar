package study.step3;


import java.util.ArrayList;
import java.util.List;

public class Track {
    private List<Car> cars = new ArrayList<>();
    private int attemptCount;
    private ResultView resultView;

    Track( int attemptCount, ResultView resultView) {
        this.attemptCount = attemptCount;
        this.resultView = resultView;
    }

    public void setCar(int count) {
        for (int i = 0; i < count; i++) {
            cars.add(new Car());
        }
    };

    public void startRacing() {
        for (int i = 0; i < attemptCount; i++) {
            startCar(cars);
            resultView.outPut(cars);
        }
    }

    public void startCar(List<Car> cars) {
        for(int i = 0; i < cars.size(); i++) {
            cars.get(i).calcMove();
            cars.get(i).getMoveValue();
        }
    }

    public int getCarsCount() {
        return cars.size();
    }

    public int getAttemptCount() {
        return attemptCount;
    }

}
