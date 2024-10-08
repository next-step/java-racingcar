package racing.entity;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        if (canMove()) {
            position += 1;
        }
    }

    private boolean canMove() {
        int randomValue = (int) (Math.random() * 10);
        return randomValue >= 4;
    }
}


