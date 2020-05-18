package step3;

import java.util.ArrayList;
import java.util.List;


public class RacingGame {

    private List<Car> cars = new ArrayList<>();
    private int tryTimes;

    public RacingGame() {
        // set new car
        int carsCnt = InputView.setCarsCount();
        for (int i = 0; i < carsCnt; i++) {
            cars.add(new Car(i));
        }
        tryTimes = InputView.setPlayCounts();
    }

    public void play() {
        System.out.println(tryTimes + 1 + " th Try.. ");
        ResultView resultView = new ResultView(cars);
        for (int i = 0; i < tryTimes; i++) {
            for (Car car : cars) {
                car.move();
            }
            resultView.viewResult();
        }
    }




}
