package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

import static racingcar.Dice.roll;

public class RacingSimulator {

    private int tryCount;
    private List<RacingCar> racingCars;

    public RacingSimulator(List<String> carNames, int tryCount) {
        this.tryCount = tryCount;
        this.racingCars = initRacingCars(carNames);
    }

    public void simulate() {
        eachCarAction(racingCars);
    }

    private static void eachCarAction(List<RacingCar> racingCars) {
        racingCars.forEach(racingCar -> racingCar.action(roll()));
    }


    private static List<RacingCar> initRacingCars(List<String> carNames) {
        List<RacingCar> racingCars = new ArrayList<>();
        for (int i = 0; i < carNames.size(); i++) {
            racingCars.add(new RacingCar(carNames.get(i)));
        }
        return racingCars;
    }

    public boolean isEnd() {
        return --tryCount < 0;
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }
}