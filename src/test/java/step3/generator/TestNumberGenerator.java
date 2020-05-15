package step3.generator;

public class TestNumberGenerator implements GenerateNumberStrategy {

    private final int num;

    public TestNumberGenerator(int num) {
        this.num = num;
    }

    @Override
    public boolean isMove() {
        return num >= 4;
    }
}
