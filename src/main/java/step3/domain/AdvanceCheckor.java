package step3.domain;

public class AdvanceCheckor {

    private final int ADVANCE_MIN_NUMBER = 4;

    public boolean check(int input) {
        return input >= ADVANCE_MIN_NUMBER;
    }
}
