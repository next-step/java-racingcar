package racingcar;

import java.util.List;

public class ResultView {
    private List<Car> racingCars;
    private RacingModel racingModel;

    public ResultView(List<Car> racingCars, RacingModel racingModel) {
        this.racingCars = racingCars;
        this.racingModel = racingModel;
    }
    
    public void printEachRacingStep() {
        for (Car racingCar : racingCars) {
            System.out.println(racingCar.getPosition());
        }
        System.out.println();
    }
}
