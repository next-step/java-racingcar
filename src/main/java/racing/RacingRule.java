package racing;

import java.util.Random;

public class RacingRule {

    public static final int ATTACKABLE_STANDARD = 4;

    public boolean isAttackable() {
        return this.isAttackable(this.attack());
    }

    public boolean isAttackable(int attackNumber) {
        return attackNumber >= ATTACKABLE_STANDARD;
    }

    private int attack() {
        Random random = new Random();
        return random.nextInt(9);
    }

}
