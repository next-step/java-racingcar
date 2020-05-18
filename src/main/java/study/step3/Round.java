package study.step3;

import java.util.ArrayList;
import java.util.List;

public class Round {
    private static final int INIT_ZERO = 0;

    private RacingGame racingGame;
    private List<Car> cars;

    public Round(List<Car> cars) {
        this.cars = cars;
    }

    public Round(RacingGame racingGame) {
        this.racingGame = racingGame;
        this.cars = initCars();
    }

    public List<Car> getCars(){
        return new ArrayList<>(cars);
    }

    private List<Car> initCars() {
        List<Car> initCars = new ArrayList<>();
        for (int i = INIT_ZERO; i < racingGame.getCarNumbers(); i++){
            initCars.add(new Car());
        }
        return initCars;
    }
}
