package racing;

import java.util.*;
import java.util.stream.Collectors;

public class RaceControll {

    private List<RacingCar> cars = new ArrayList<>();

    public RaceControll(String names) {
        this.registrationCars(names);
    }

    public List<Driver> getWinners() {
        int winningPosition = this.cars.stream()
                .map(RacingCar::getPosition)
                .mapToInt(Position::getPoistion)
                .max()
                .getAsInt();

        return this.cars.stream()
                .filter(car -> car.getPosition().getPoistion() == winningPosition)
                .map(RacingCar::getDriver).collect(Collectors.toList());
    }

    private void registrationCars(String names) {
        this.cars = Arrays.stream(names.split(","))
                .map(name -> new RacingCar(name))
                .collect(Collectors.toList());
    }

    public void raceSingleRound() {
        RacingRule rule = new RacingRule();
        for(RacingCar car : this.cars) {
            boolean isAttackable = rule.isAttackable();
            car.attack(isAttackable);
        }
    }

    public List<RacingCar> getCars() {
        return this.cars;
    }
}
