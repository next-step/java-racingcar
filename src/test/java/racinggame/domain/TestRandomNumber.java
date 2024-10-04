package racinggame.domain;

public class TestRandomNumber extends RandomNumber {
    private final int value;

    public TestRandomNumber(int number) {
        this.value = number;
    }

    @Override
    public int getValue() {
        return this.value;
    }
}
