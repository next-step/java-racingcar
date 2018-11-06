package rcgame.util;

public class TestNumberGenerator implements NumberGenerator{
    private int testNumber = 0;

    public void setTestNumber(int testNumber) {
        this.testNumber = testNumber;
    }

    public int getRandomNumber() {
        return testNumber;
    }
}
