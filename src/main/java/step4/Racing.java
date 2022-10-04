package step4;

import java.util.List;

public class Racing {


    public void racing (List<Car> cars, int times, OutputRacingCar outputResult) {
        for (int i = 0 ; i < times ; i++) {
            outputResult.printRound(racingRound(cars));
        }
    }

    public List<Car> racingRound(List<Car> cars) {
        for (int i = 0; i < cars.size() ; i++) {
            cars.get(i).moveOrStop();
        }
        return cars;
    }


}
