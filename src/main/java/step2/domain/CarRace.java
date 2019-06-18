package step2.domain;

import step2.view.OutputView;

import java.util.ArrayList;

public class CarRace {

    private Cars cars;
    private final int numberOfTrials;
//    private RaceExecutor raceExecutor;

    public CarRace(int numberOfCars, int numberOfTrials) {
        makeCars(numberOfCars);
        this.numberOfTrials = numberOfTrials;
//        this.raceExecutor = new RaceExecutor(this.cars);
    }

    private void makeCars(int numberOfCars) {
        Cars cars = new Cars(new ArrayList<>());
        for (int i = 0; i < numberOfCars; i++) {
            cars.getCars().add(new Car());
        }
    }

    public void raceExecute() {
        System.out.println("실행 결과"); //TODO: view에 위임
//        raceExecutor.executeTrials(numberOfTrials);
    }
}
