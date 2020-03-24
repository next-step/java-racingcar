package fifth_refactoring.domain;

public class Car implements Comparable{
    private String carName;
    private int carPosition;

    public Car(String carName) {
        this.carName = carName;
        this.carPosition = 1;
    }

    public String getCarName() {
        return this.carName;
    }

    public int getCarPosition() {
        return this.carPosition;
    }

    public void move() {
        this.carPosition++;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    @Override
    public int compareTo(Object o) {
        return this.carPosition - ((Car)o).carPosition;
    }

    public String toString(){
        return carName;
    }
}
