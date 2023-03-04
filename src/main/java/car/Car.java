package car;

public class Car {
    private final CarName name;
    private int position = 0;

    public Car(CarName name, int position) {
        this.name = name;
        this.position = position;
    }

    public Car(String name) {
        this.name = new CarName(name);
    }

    public void printPositionStatus() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < position; i++) {
            sb.append("-");
        }
        String currentPosition = sb.toString();
        System.out.println(this.name + " : " + currentPosition);
    }

    public void move(int randomValue) {
        if (randomValue >= 4) {
            this.position++;
        }
        printPositionStatus();
    }

    public boolean isGreaterThan(int maxPosition) {
        return this.position > maxPosition;
    }

    public boolean isEqualPosition(int maxPosition) {
        return this.position == maxPosition;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return this.name.getName();
    }
}
