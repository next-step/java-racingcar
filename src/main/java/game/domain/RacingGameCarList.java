package game.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGameCarList {

    private List<RacingGameCar> cars;

    private RacingGameCarList(List<RacingGameCar> cars) {
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

}
