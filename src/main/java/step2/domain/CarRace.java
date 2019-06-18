package step2.domain;

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



//    public void raceExecute() {
//        System.out.println("실행 결과"); //TODO: view에 위임
//        raceExecutor.executeTrials(numberOfTrials);
//    }
}
