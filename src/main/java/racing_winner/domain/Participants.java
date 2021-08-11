package racing_winner.domain;

import racing_winner.strategy.RacingStrategy;

import java.util.ArrayList;
import java.util.List;

public class Participants {

    private List<Car> cars;

    public Participants(final String[] carNames) {
        this.cars = setParticipants(carNames);
    }

    public List<Car> setParticipants(String[] carNames){
        List<Car> car = new ArrayList<>();
        for (String name : carNames){
            car.add(new Car(name));
        }
        return car;
    }

    public int getParticipantList(){
        return cars.size();
    }

    public RacingResult race(final RacingStrategy racingStrategy) {
        List<Car> result = new ArrayList<>();
        for(Car car : cars) {
            car.move(racingStrategy);
            result.add(car);
        }
        return new RacingResult(result);
    }

}
