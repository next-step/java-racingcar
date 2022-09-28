package game.domain;

import game.domain.car.RacingGameCar;

import java.util.ArrayList;
import java.util.List;

public class RacingGameCarList {

    private List<RacingGameCar> cars;

    public RacingGameCarList(List<RacingGameCar> cars) {
        this.cars = cars;
    }

    public List<RacingGameCar> cars() {
        return cars;
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
        return cars.get(cars.size()-1);
    }

}
