package racinggame;

public class TestNumber implements GenerateNumber {

    private final int number;

    public TestNumber(int number) {
        this.number = number;
    }

    @Override
    public int number() {
        return this.number;
    }

}
