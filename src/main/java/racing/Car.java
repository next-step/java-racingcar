package racing;

public class Car {
    public String name;
    public int moveStatus;

    public Car(String name) {
        this.name = name;
    }

    public void move(int moveOrStop) {
        moveStatus += moveOrStop;
    }
}
