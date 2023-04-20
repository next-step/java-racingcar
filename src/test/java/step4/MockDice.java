package step4;

public class MockDice implements Dice {

    private int testNum;

    public MockDice(int testNum) {
        this.testNum = testNum;
    }

    @Override
    public int getNum() {
        return testNum;
    }
}
