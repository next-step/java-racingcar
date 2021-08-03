package racingCar.domain;

@FunctionalInterface
public interface CarNamePolicy {

    Boolean isPossibleName(String name);

}
