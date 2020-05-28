package racing.domain;

public class Car {
    private static final int MOVE_MIN_NUMBER = 4;
    private String name;
    private int position;

    public Car(String name) {
        this.name = name;
    }

    public void move(int diceNumber) {
        if (isMoveTime(diceNumber)) {
            position++;
        }
    }

    public Car deepCopyCar() {
        Car copyCar = new Car(this.name);
        copyCar.position = this.position;

        return copyCar;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    private boolean isMoveTime(int diceNumber) {
        return diceNumber >= MOVE_MIN_NUMBER;
    }
}
