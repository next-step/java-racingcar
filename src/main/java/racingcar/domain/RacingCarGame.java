package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RacingCarGame {
    private List<RacingCar> carList;
    public RacingCarGame(int carCount) {
        this.carList = createCarList(carCount);
    }

    // 정적 팩토리 메서드 구현
    public static List<RacingCar> createCarList(int carCount) {
        return Stream.generate(RacingCar::new)
                .limit(carCount)
                .collect(Collectors.toList());
    }

    public List<RacingCar> playRoundsAndReturnCarList() {
        return null;
    }
}