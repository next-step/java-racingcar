package racingcar;

import racingcar.rule.RacingRule;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingCarDriver {

    private List<RacingCar> racingCars;

    public RacingCarDriver(int amount) {
        this(RacingCarDriver.createRacingCars(amount));
    }

    public RacingCarDriver(List<RacingCar> racingCars) {
        if (racingCars != null) {
            this.racingCars = racingCars;
        }
    }

    /**
     * 주어진 수 만큼 자동차를 만들어 리스트에 담아 리턴합니다.
     * @param amount
     * @return
     */
    public static List<RacingCar> createRacingCars(int amount) {
        List<RacingCar> racingCars = new ArrayList<>(amount);
        for (int i = 0; i < amount; i++) {
            racingCars.add(new RacingCar());
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
}
