package domain;

import java.util.Random;

public class RandomNumberCondition implements Condition{
    private int startNumber;
    private int endNumber;
    private int conditionNumber;
    private Random random = new Random();

    public RandomNumberCondition(int startNumber, int endNumber, int conditionNumber) {
        this.startNumber = startNumber;
        this.endNumber = endNumber + 1;
        this.conditionNumber = conditionNumber;
    }

    @Override
    public boolean canPass() {
        return generateNumber() > conditionNumber;
    }

    private int generateNumber(){
        return random.nextInt(endNumber - startNumber) + startNumber;
    }
}
