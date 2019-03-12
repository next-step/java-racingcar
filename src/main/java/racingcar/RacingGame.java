package racingcar;

import racingcar.car.Car;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private int time;
    private List<Car> cars;

    private int topPosition = 0;

    public RacingGame(String[] racers, int time) {
        this.time = time;
        registerRacer(racers);
    }

    public void registerRacer(String[] racers) {
        cars = new ArrayList<Car>();
        for (int i = 0; i < racers.length; i++) {
            cars.add(new Car(racers[i], 0));
        }
    }

    public List<Car> game() {
        for (int i = 0; i < time; i++) {
            move();
        }

        return cars;
    }

    //TODO : 더 좋은 출력방법 있는지 고민해보기..
    public void move() {
        for (Car car : cars) {
            int position = car.move();
            checkTopPosition(position);
            OutputView.showStatus(car.getName(), position);
        }
        OutputView.nextTurn();
    }

    public void checkTopPosition(int position) {
        if (topPosition < position) {
            topPosition = position;
        }
    }

    //TODO : getter를 아예 없앨 방법을 생각해봐야하는데...
    public int getTopPosition() {
        return topPosition;
    }
}

