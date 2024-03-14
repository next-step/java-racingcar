package step3;

public class Car {
    private static final int MIN_AVAILABLE_CHANCE = 4;

    private String position = "-";

    public Car() {
    }

    public void move(int chance) {
        if (chance >= MIN_AVAILABLE_CHANCE){
            this.position += "-";
        }
    }
    public String getPosition() {
        return position;
    }
}
