package RacingCar.model;

import NumberGenerator.NumberGenerator;

public class RacingCar {
    private final int moveCondition;
    private String name;
    private int position;
    private final NumberGenerator numberGenerator;

    public RacingCar(int moveCondition, NumberGenerator numberGenerator, String name) {
        this.name = name;
        this.moveCondition = moveCondition;
        this.position = 0;
        this.numberGenerator = numberGenerator;
    }

    // ==============================
    // 🔹 Internal logic methods
    // ==============================
    boolean canMove(int num) {
        return num >= this.moveCondition;
    }

    public void move() {
        if (canMove(numberGenerator.generate(0, 9))) {
            this.position++;
        }
    }

    public int position() {
        return this.position;
    }

    public String name(){
        return this.name;
    }
}

