import java.util.Random;

public class FakeDiceRoller implements DiceRoller {
    private Random random;
    private int randomNumber;

    public FakeDiceRoller(Random random) {
        this.random = random;
    }

    public boolean goeThan4() {
        return randomNumber >= 4;
    }

    public int getRandomNumber() {
        return randomNumber;
    }

    public void setRandomNumber(int randomNumber) {
        this.randomNumber = randomNumber;
    }
}
