package champion;

public class Car {

    private static final int MAX_CAR_NAME_LENGTH = 5;
    private int position;
    private String name;

    public Car(String name) {
        this.position = 0;
        this.name = name;
    }

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public void move(int randomNumber) {
        if (randomNumber >= 4) {
            this.position++;
        }
    }

    public String carName() {
        return this.name;
    }

    public int currentPosition() {
        return this.position;
    }

}
