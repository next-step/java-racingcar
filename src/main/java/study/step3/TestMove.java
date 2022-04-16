package study.step3;

public class TestMove implements MoveStrategy{
    private int value;

    public TestMove(int value) {
        this.value = value;
    }

    @Override
    public int getValue() {
        return value;
    }
}
