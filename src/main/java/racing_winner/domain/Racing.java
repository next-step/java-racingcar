package racing_winner.domain;

import racing_winner.strategy.RacingStrategy;

import java.util.ArrayList;
import java.util.List;

public final class Racing {

    private List<Car> racingCar;

    public Racing(final List<Car> racingCar) {
        this.racingCar = racingCar;
    }

    public List<Car> getRacingCar() {
        return racingCar;
    }

    public static Racing setRacingCars(final String[] racingCars){
        List<Car> car = new ArrayList<>();
        for (String name : racingCars){
            car.add(new Car(name));
        }
        return new Racing(car);
    }

    public int getRacingNumber(){
        return racingCar.size();
    }

    public void move(final RacingStrategy racingStrategy) {
        for(Car car : racingCar){
            car.move(racingStrategy);
        }
    }

    public int findMaxDistance(){
        int maxDistance = 0;
        for (Car car : racingCar) {
            maxDistance = car.findFartherDistance(maxDistance);
        }
        return maxDistance;
    }

    public List<Car> findWinners(){
        List<Car> winners = new ArrayList<>();
        int maxDistance = findMaxDistance();

        racingCar.stream()
                .filter(car -> car.compareDistance(maxDistance))
                .forEach(winners::add);

        return winners;
    }
}
