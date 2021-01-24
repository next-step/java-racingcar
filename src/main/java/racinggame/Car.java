package racinggame;

public class Car {
    private String name;
    private int status;

    public Car(String name) {
        this.name = name;
        this.status = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "RacingCar{" +
                "name='" + name + '\'' +
                ", status=" + status +
                '}';
    }

    public void movingForward() {
        this.status++;
    }
}
