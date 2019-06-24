package racingcar.model;

import racingcar.utils.NumGenerator;
import racingcar.utils.StringUtil;

import java.util.ArrayList;
import java.util.List;


public class RacingGame {
    private final String SEPARATOR = ",";
    private int times;
    private NumGenerator numGenerator;
    private Cars cars;

    public RacingGame(String carNames, int times, NumGenerator numGenerator) {
        this.times = times;
        this.numGenerator = numGenerator;
        this.cars = createCars(carNames);
    }

    public Cars getCars() {
        return this.cars;
    }

    public Cars run() {
        if (this.times < 0){
            return cars;
        }
        cars.move();
        this.times--;
        return cars;
    }

    public boolean isMovable(){
        return this.times > 0;
    }

    private Cars createCars(String carNames) {
        List<Car> lCars = new ArrayList<>();
        String[] newCarNames = StringUtil.splitBySeparator(SEPARATOR, carNames);
        for (String carName : newCarNames) {
            lCars.add(new Car(carName, this.numGenerator));
        }
        return new Cars(lCars);
    }

}
