package domain;

public class Car {

    private String name;
    private int distance;
    private static final Integer MOVE = 1;

    public Car() {
    }

    public Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    public String getName() {
        return this.name;
    }

    public int getDistance() {
        return this.distance;
    }

    public void move() {
        this.distance = this.distance + MOVE;
    }

    public void moveWithConditon(int value, int condition) {
        if (value >= condition) {
            this.distance = this.distance + MOVE;
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < this.getDistance(); i++) {
            result.append("-");
        }
        return result.toString();
    }
}
