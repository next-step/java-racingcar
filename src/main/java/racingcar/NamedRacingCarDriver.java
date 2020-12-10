package racingcar;

import racingcar.rule.RacingRule;

import java.util.ArrayList;
import java.util.List;

public class NamedRacingCarDriver extends RacingCarDriver{

    private List<NamedRacingCar> racingCars;

    public NamedRacingCarDriver(String[] participants) {
        super(NamedRacingCarDriver.createNamedRacingCars(participants));
    }

    public static List<RacingCar> createNamedRacingCars(String[] participants) {
        List<RacingCar> racingCars = new ArrayList<>();
        for (String participant : participants) {
            racingCars.add(new NamedRacingCar(participant));
        }
        return racingCars;
    }

}
