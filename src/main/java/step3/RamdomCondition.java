package step3;

import java.util.Random;

public class RamdomCondition implements ConditionInterface{
    private static final int RANDOM_NUMBER_BOUND = 10;
    private static final int ADVANCE_CONDITION = 4;

    private Random ramdom;

    private int RandomValue;

    public RamdomCondition() {
        this.ramdom = new Random();
    }

    public RamdomCondition(int RandomValue) {
        this.RandomValue = RandomValue;
    }

    // 삭제 예정
    public boolean meet(int compare) {
        return ramdom.nextInt(RANDOM_NUMBER_BOUND) > compare;
    }

    public boolean meet() {
        return this.RandomValue > ADVANCE_CONDITION;
    }
}
