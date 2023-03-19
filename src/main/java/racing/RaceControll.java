package racing;

import java.util.*;
import java.util.stream.Collectors;

public class RaceControll {

    private List<RacingCar> cars = new ArrayList<>();

    public RaceControll(String names) {
        this.registrationCars(names);
    }

    public String getWinners() {
        return this.cars.stream()
                .collect(Collectors.groupingBy(RacingCar::getPosition))
                    .entrySet()
                        .stream()
                            .max(Comparator.comparing(Map.Entry::getKey))
                                .get()
                                    .getValue()
                .stream()
                    .map(RacingCar::getDriver)
                        .map(Driver::getName)
                            .collect(Collectors.joining(", "));
    }

    private void registrationCars(String names) {
        this.cars = Arrays.stream(names.split(","))
                .map(name -> new RacingCar(name))
                .collect(Collectors.toList());
    }

    public void raceSingleRound() {
        RacingRule rule = new RacingRule();
        this.cars.stream()
                .forEach(car -> {
                    boolean isAttackable = rule.isAttackable();
                    car.attack(isAttackable);
                });
    }

    public List<RacingCar> getCars() {
        return this.cars;
    }
}
