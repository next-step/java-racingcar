package step3;

public class MoveNumberGenerator implements NumberGenerator {

    @Override
    public int generate() {
        return Car.MOVE_CONDITION_THRESHOLD;
    }
}
