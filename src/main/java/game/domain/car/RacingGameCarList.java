package game.domain.car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingGameCarList {

    private final List<RacingGameCar> cars;

    public RacingGameCarList(List<RacingGameCar> cars) {
        this.cars = cars;
    }

    public RacingGameCarList(RacingGameCarList racingGameCarList) {
        this(racingGameCarList.cars());
    }

    public List<RacingGameCar> cars() {
        return Collections.unmodifiableList(cars);
    }

    public static RacingGameCarList makeRacingGameCars(int number) {
        List<RacingGameCar> racingGameCarList = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            racingGameCarList.add(new RacingGameCar());
        }
        return new RacingGameCarList(racingGameCarList);
    }

    public static RacingGameCarList makeRacingGameCars(List<String> names) {
        List<RacingGameCar> racingGameCarList = new ArrayList<>();
        for (String name : names) {
            racingGameCarList.add(new RacingGameCar(name));
        }
        return new RacingGameCarList(racingGameCarList);
    }

    public RacingGameCar getLast(){
        return new RacingGameCar(cars.get(cars.size()-1));
    }

    public RacingGameCarList winners() {
        return winners(winnerLocation());
    }

    private RacingGameCarList winners(Location winnerLocation) {
        List<RacingGameCar> result = new ArrayList<>();
        for (RacingGameCar car : cars()) {
            isWinner(winnerLocation, result, car);
        }
        return new RacingGameCarList(result);
    }

    private static void isWinner(Location winnerLocation, List<RacingGameCar> result, RacingGameCar car) {
        if(car.location().equals(winnerLocation)){
            result.add(car);
        }
    }

    private Location winnerLocation() {
        int max = Integer.MIN_VALUE;
        for (RacingGameCar car : cars()) {
            max = Math.max(car.location().getLocation(),max);
        }
        return new Location(max);
    }
}
