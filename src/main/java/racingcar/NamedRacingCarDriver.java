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
            racingCars.add(new NamedRacingCar(NamedRacingCarDriver.validateName(participant)));
        }
        return racingCars;
    }

    public static String validateName(String name) {
        if(name != null && name.length() <= 5) {
            return name;
        }
        throw new IllegalArgumentException("이름의 길이가 적절하지 않습니다.");
    }

}
