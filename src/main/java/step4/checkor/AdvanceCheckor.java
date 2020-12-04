package step4.checkor;

public class AdvanceCheckor implements Checkor<Boolean, Integer> {

    private static final int ADVANCE_MIN_NUMBER = 4;

    @Override
    public Boolean check(Integer input) {
        return input >= ADVANCE_MIN_NUMBER;
    }

}
