package racing;

import java.util.Random;

public class TestGenerateNumber implements GenerateNumber{

    private final int number;

    public TestGenerateNumber(int number) {
        this.number = number;
    }

    @Override
    public int getRandomNumber() {
        return number;
    }
}
