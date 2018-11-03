package racing.domain;

import racing.util.RandomNumberProvider;

public class TestNumberProvider implements RandomNumberProvider {
    private int testNumber = 0;

    public void setTestNumber(int testNumber) {
        this.testNumber = testNumber;
    }

    @Override
    public int getRandomNumber() {
        return testNumber;
    }

}
