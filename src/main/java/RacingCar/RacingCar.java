package RacingCar;

import java.util.Random;

public class RacingCar {
    private int moveCondition;
    private int position;
    private Random random;

    public RacingCar(int moveCondition) {
        this.moveCondition = moveCondition;
        this.position = 0;
        this.random = new Random();
    }

    // ==============================
    // 🔹 Internal logic methods
    // ==============================
    boolean canMove(int num) {
        return num >= this.moveCondition;
    }

    void move() {
        this.position += 1;
    }

    int generateRandom(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }

    int position(){
        return this.position;
    }
}

