package rcgame.domain;


import rcgame.util.NumberGenerator;
import rcgame.util.RandomNumberGenerator;

public class RcCar {
    public static final int MOVE_BOUND_VALUE = 4;
    public static NumberGenerator numberGenerator = new RandomNumberGenerator();

    public static void setNumberGenerator(NumberGenerator numberGenerator) {
        RcCar.numberGenerator = numberGenerator;
    }

    private String name;
    private int position;

    public RcCar() {
        this.position = 0;
    }

    public RcCar(String name) {
        this.name = name;
        this.position = 0;
    }

    public RcCar(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public RcCar move() {
        if (numberGenerator.getRandomNumber() >= MOVE_BOUND_VALUE) {
            position ++;
        }
        return new RcCar(name, position);
    }

    public int getPosition() {
        return position;
    }

    public String getName() { return name; }

    public boolean isSamePosition(int targetPosition){
        return this.position == targetPosition;
    }
}
