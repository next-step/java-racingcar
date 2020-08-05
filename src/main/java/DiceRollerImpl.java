import java.util.Random;

public class DiceRollerImpl implements DiceRoller {
    private Random random;
    private int randomNumber;

    public DiceRollerImpl(Random random) {
        this.random = random;
    }

    public boolean goeThan4() {
        randomNumber = random.nextInt(10);
        return randomNumber >= 4;
    }
}
