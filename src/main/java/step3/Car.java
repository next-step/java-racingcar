package step3;

import java.util.Random;

public class Car {
    // Car
    // --- 각 자동차는 전진한다. 단, 랜덤 숫자가 4이상일 때.
    private int position;

    private void rollDice () {
        int random = new Random().nextInt(10);
        if(random >= 4 ) {
            position++;
        }
    }

    public String move() {
        this.rollDice();
        return "-".repeat(position);
    }
}
