package RcingCarV2;

import RcingCarV2.model.Car;
import RcingCarV2.model.StageResult;

import java.util.ArrayList;
import java.util.List;

public class RacingCar {

    void start(List<String> names, int stage) {
        List<Car> cars = initCars(names);
        List<StageResult> stageResults = initStageResult(cars, stage);

        System.out.println(cars);
        System.out.println(stageResults);


    }

    List<Car> initCars(List<String> names) {
        List<Car> cars = new ArrayList<>();
        for (String name: names) {
            cars.add(new Car(name));
        }
        return cars;
    }

    List<StageResult> initStageResult(List<Car> cars, int stage) {
        List<StageResult> stageResults = new ArrayList<>();
        for (int i = 0; i < stage; i++) {
            stageResults.add(new StageResult(cars, i));
        }
        return stageResults;
    }
}
