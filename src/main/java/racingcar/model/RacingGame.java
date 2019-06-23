package racingcar.model;

import racingcar.utils.NumGenerator;
import racingcar.utils.StringUtil;

import java.util.ArrayList;
import java.util.List;


public class RacingGame {
    private final String SEPARATOR = ",";
    private String carNames;
    private int times;
    private NumGenerator numGenerator;
    private Cars cars;

    public RacingGame(String carNames, int times, NumGenerator numGenerator) {
        this.carNames = carNames;
        this.times = times;
        this.numGenerator = numGenerator;
    }

    public Cars run() {
        cars = createCars(this.carNames);
        for (int i = 0; i < this.times; i++) {
            cars.move();
            cars.printResult();
            System.out.println();
        }
        return cars;
    }

    private Cars createCars(String carNames) {
        List<Car> lCars = new ArrayList<>();
        String[] newCarNames = StringUtil.splitBySeparator(SEPARATOR, carNames);
        for (String carName : newCarNames) {
            lCars.add(new Car(carName, 0, this.numGenerator));
        }
        return new Cars(lCars);
    }

}
