package racing;

public class Car {
    public int moveStatus;

    public void move(int goOrStop) {
        moveStatus += goOrStop;
    }
}
