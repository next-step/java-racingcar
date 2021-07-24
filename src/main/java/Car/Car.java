package Car;

public class Car {
    String status;
    int moveCount;

    public Car() {
        this.status = "-";
        this.moveCount = 1;
    }

    public String getStatus() {
        return this.status;
    }

    public void move() {
        this.moveCount++;
        this.status += "-";
    }
}
