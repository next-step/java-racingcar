package racingcar;

import racingcar.rule.RacingRule;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingCarDriver {

    private List<RacingCar> racingCars;

    public RacingCarDriver(List<RacingCar> racingCars) {
        if (racingCars != null) {
            this.racingCars = racingCars;
        } else {
            this.racingCars = new ArrayList<>();
        }
    }

    public static List<RacingCar> createRacingCars(List<String> participants) {
        List<RacingCar> racingCars = new ArrayList<>();
        for (String participant : participants) {
            racingCars.add(new RacingCar(participant));
        }
        return racingCars;
    }


    /**
     * 주어진 룰에 맞게 생성된 숫자로 등록된 모든 자동차를 전진시킵니다.
     * @param racingRule
     */
    public void moveForwardAll(RacingRule racingRule) {
        for (RacingCar racingCar : this.racingCars) {
            racingCar.move(racingRule.getNumber());
        }
    }

    /**
     * 자동차의 현재 위치를 받아서 리스트에 담습니다.
     * @return
     */
    public List<Integer> getNowDistance() {
        List<Integer> nowDistances = new ArrayList<>();
        for (RacingCar racingCar : this.racingCars) {
            nowDistances.add(racingCar.getDistance());
        }
        return nowDistances;
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }
}
