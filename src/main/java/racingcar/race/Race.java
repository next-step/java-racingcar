package racingcar.race;

import racingcar.car.Cars;
import racingcar.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private List<Cars> race;
    private Cars cars;
    private int racingTime;

    public Race() {
        race = new ArrayList<>();
        cars = new Cars(InputView.inputNameOfCars());
        racingTime = Integer.parseInt(InputView.inputCountOfGame());
    }

    public void startRace() {
        for (int i = 0; i < racingTime; i++) {
            cars.moveCars();
            race.add(new Cars(cars.getCars()));
        }
    }

    public List<Cars> getRace() {
        return this.race;
    }

}
