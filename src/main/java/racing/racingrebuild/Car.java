package racing.racingrebuild;

public class Car {
    private String carName;
    private int location;


    public Car(String carName) {
        this.carName = carName;

    }

    public Car(String carName, int location) {
        this.carName = carName;
        this.location = location;

    }

    public void move(int number) {
        if (number >= 4) {
            location++;
        }
    }

    public String getCarName() {
        return carName;
    }

    public int getLocation() {
        return location;
    }



}
