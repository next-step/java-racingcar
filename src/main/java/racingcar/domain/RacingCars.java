package racingcar.domain;

import racingcar.domain.value.CarName;
import racingcar.domain.value.Position;
import racingcar.service.util.MoveRuleUtil;
import racingcar.service.util.Validation;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {

    private final List<RacingCar> racingCars;

    public RacingCars(List<RacingCar> carList) {

        this.racingCars = carList;
    }

    public static RacingCars from(List<String> carName) {

        Validation.nullValueCheck(carName);

        List<RacingCar> racingCars = carName.stream()
                .map(RacingCar::create)
                .collect(Collectors.toList());

        return new RacingCars(racingCars);
    }

    public RacingCars playTheGame() {
        MoveRuleUtil moveRuleUtil = new MoveRuleUtil();

        List<RacingCar> carList = this.getCars();
        for(int i = 0; i < carList.size(); i++) {
            carList.get(i).decisionMove(moveRuleUtil.moveOrNot());
        }

        return new RacingCars(carList);
    }

    public List<RacingCar> getCars() {

        return racingCars;
    }

    public String getVictoryUsers() {
        Position maxPosition = getMaxPosition();
        return racingCars.stream()
                .filter(car -> car.isWinner(maxPosition))
                .map(RacingCar::getCarName)
                .map(CarName::getName)
                .collect(Collectors.joining(","));
    }

    private Position getMaxPosition() {
        Position maxPosition = Position.create(0);
        for (RacingCar car : racingCars) {
            maxPosition = car.getMaxPosition(maxPosition);
        }
        return maxPosition;
    }

}
