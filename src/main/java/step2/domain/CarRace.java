package step2.domain;

import step2.view.OutputView;

import java.util.ArrayList;

public class CarRace {

    private Cars cars;
    private int numberOfTrials;

    private CarRace(Cars cars, int numberOfTrials) {
        this.cars = cars;
        this.numberOfTrials = numberOfTrials;
    }

    public CarRace raceExecute(int numberOfCars, int numberOfTrials) {
        return new CarRace(Cars.makeCars(numberOfCars), numberOfTrials);
    }


//    private void makeCars(int numberOfCars) {
//        Cars cars = new Cars(new ArrayList<>());
//        for (int i = 0; i < numberOfCars; i++) {
//            cars.getCars().add(new Car());
//        }
//    }

//    public void raceExecute() {
//        System.out.println("실행 결과"); //TODO: view에 위임
//        raceExecutor.executeTrials(numberOfTrials);
    }
}
