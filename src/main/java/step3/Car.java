package step3;

import java.util.Random;

public class Car {

    private static final Random random = new Random();

    private String miles = "-";

    private boolean canAdvance() {
        return random.nextInt(10) >= 4;
    }

    public void advance() {
        if (canAdvance()) {
            this.miles = this.miles.concat("-");
        }
    }

    public String getMiles() {
        return this.miles;
    }

}
