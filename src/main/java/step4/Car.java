package step4;

public class Car {
    private final String carName;
    private Integer position = 0;

    public Car(final String carName, int position) {

        this.carName = carName;
        this.position = position;
    }

    public String getName() {
        return carName;
    }

    public Integer getPosition() {
        return position;
    }

    public Integer compareAndGetMax(int compare) {
        if(compare>position) return compare;
        return position;
    }

    public void move() {
        position++;
    }
}
