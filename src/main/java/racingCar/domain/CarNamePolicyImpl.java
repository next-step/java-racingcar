package racingCar.domain;

public class CarNamePolicyImpl implements CarNamePolicy {

    private static final int THRESHOLD = 5;

    public Boolean isPossibleName(String name) {
        return checkStringLength(name);
    }

    private boolean checkStringLength(String name) {
        return name.length() <= THRESHOLD;
    }

}
