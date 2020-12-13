package racingcar;

import racingcar.domain.RacingCar;
import racingcar.domain.RacingCars;
import racingcar.rule.RacingRule;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarDriver {

    private final RacingCars racingCars;

    public RacingCarDriver(RacingCars racingCars) {
        this.racingCars = racingCars;
    }

    public RacingCarDriver(List<String> participants) {
        List<RacingCar> racingCars = new ArrayList<>();
        for (String participant : participants) {
            racingCars.add(new RacingCar(participant));
        }
        this.racingCars = new RacingCars(racingCars);
    }


    /**
     * 주어진 룰에 맞게 생성된 숫자로 등록된 모든 자동차를 전진시킵니다.
     * @param racingRule
     */
    public void moveForwardAll(RacingRule racingRule) {
        for (RacingCar racingCar : this.racingCars.getRacingCars()) {
            racingCar.move(racingRule.getNumber());
        }
    }

    /**
     * 자동차의 현재 위치를 받아서 리스트에 담습니다.
     * @return
     */
    public List<Integer> getNowDistance() {
        return this.racingCars.getRacingCars().stream()
                .map(racingCar -> racingCar.getDistance())
                .collect(Collectors.toList());
    }

    public List<RacingCar> getRacingCars() {
        return racingCars.getRacingCars();
    }

    public List<String> findWinner() {
        return this.racingCars.findWinner();
    }
}
