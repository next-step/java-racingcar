package race;

public class CarRandomMoveRule implements CarMoveRule {
    public static final int BOUND_OF_RANDOM = 10;
    private static final int STANDARD = 4;

    private CarRandomMoveRule() {
    }


    @Override
    public boolean check(CarMoveRuleValue carMoveRuleValue) {
        return carMoveRuleValue.isGreaterThanOrEqualTo(STANDARD);
    }

    public static CarRandomMoveRule create() {
        return new CarRandomMoveRule();
    }
}
