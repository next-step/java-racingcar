package step3;

import java.util.Random;

public class Car {
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
