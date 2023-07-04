package logic;

public class Car {
    private String name;
    private int position=0;
    public Car(String carName) {
        validateCarName(carName);
        this.name = carName;
    }

    private void validateCarName(String carName) {
        if (carName.length() >5 ) throw new RuntimeException();
    }
}
