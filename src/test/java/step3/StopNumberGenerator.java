package step3;

public class StopNumberGenerator implements NumberGenerator {

    @Override
    public int generate() {
        return Car.MOVE_CONDITION_THRESHOLD - 1;
    }
}
