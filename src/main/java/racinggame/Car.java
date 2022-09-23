package racinggame;

public class Car {
    private int status;

    public void forward() {
        this.status++;
    }

    public int getStatus() {
        return status;
    }
}
