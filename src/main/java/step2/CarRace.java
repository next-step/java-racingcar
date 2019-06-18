package step2;

import java.util.ArrayList;
import java.util.List;

public class CarRace {

    private List<Car> cars;
    private int numberOfTrials;
    private RaceExecutor raceExecutor;

    public CarRace(int numberOfCars, int numberOfTrials) {
        this.cars = makeCars(numberOfCars);
        this.numberOfTrials = numberOfTrials;
        this.raceExecutor = new RaceExecutor(this.cars); //TODO : RaceExcutor는 CarRace가 생성되어야만 필요하니까 이렇게 생성했는데 문제없을까요?
    }

    private List<Car> makeCars(int numberOfCars) {
        List<Car> cars = new ArrayList<>();
        for(int i=0; i<numberOfCars; i++) {
            cars.add(new Car());
        }
        return cars;
    }

    public void raceStart() {
        System.out.println("실행 결과");
        raceExecutor.executeTrials(numberOfTrials);
    }
}
