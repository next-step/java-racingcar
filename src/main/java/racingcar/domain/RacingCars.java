package racingcar.domain;

import racingcar.domain.value.CarName;
import racingcar.domain.value.Position;
import racingcar.service.util.MoveRuleUtil;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {

    private final List<RacingCar> carList;

    public RacingCars(List<RacingCar> carList) {

        this.carList = carList;
    }

    public static void playTheGame(RacingCars cars) {
        MoveRuleUtil moveRuleUtil = new MoveRuleUtil();

        List<RacingCar> carList = cars.getCars();
        for(int i = 0; i < carList.size(); i++) {
            carList.get(i).decisionMove(moveRuleUtil.moveOrNot());
        }
    }

    public List<RacingCar> getCars() {

        return carList;
    }

    public String getVictoryUsers() {
        Position maxPosition = getMaxPosition();
        return carList.stream()
                .filter(car -> car.isWinner(maxPosition))
                .map(RacingCar::getCarName)
                .map(CarName::getName)
                .collect(Collectors.joining(","));
    }

    private Position getMaxPosition() {
        Position maxPosition = Position.create(0);
        for (RacingCar car : carList) {
            maxPosition = car.getMaxPosition(maxPosition);
        }
        return maxPosition;
    }
}
