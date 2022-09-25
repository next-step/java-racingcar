package racinggame;

public class Car {
    private int status;

    private static final int MAX_NUMBER = 4;

    public void forward() {
        this.status++;
    }

    public int getStatus() {
        return status;
    }

    public void move(int number) {
        if (number >= MAX_NUMBER) {
            status++;
        }
    }
}
