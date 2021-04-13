package study.racingcar;

import java.util.List;

public class ResultView {
    private List<Car> cars;
    private int round = 0;

    public ResultView(List<Car> cars, int round) {
        this.cars = cars;
        this.round = round;
    }

    public void loopRound() {
        for (int i = 0; i < round; ++i) {
            doRound();
            System.out.println();
        }
    }

    public void doRound() {
        cars.forEach(car -> {
            car.move();
            car.printDistance();
        });
    }
}
