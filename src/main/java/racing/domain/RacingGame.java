package racing.domain;

import racing.dto.RancingRecode;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private Cars cars;
    private int repeat;
    private List<RancingRecode> rancingRecodes;


    public RacingGame(String nameOfCars, int repeat) {
        this.cars = Cars.from(nameOfCars);
        this.repeat = repeat;
    }

    public void run() {
        rancingRecodes = new ArrayList<>();
        for (int i = 0; i < repeat; i++) {
            cars.nextRound();
            cars.getCarList().forEach(car -> rancingRecodes.add(RancingRecode.of(car.getName(), car.getPosition())));
        }
    }

    public Cars getCars() {
        return cars;
    }

    public List<RancingRecode> getRancingRecodes() {
        return rancingRecodes;
    }
}
