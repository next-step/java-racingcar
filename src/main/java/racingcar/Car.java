package racingcar;

public class Car {

    private String carName;
    private int location;

    public Car(String carName, int location) {
        if (carName.length() >= 6) {
            throw new IllegalArgumentException("5자이하로만 입력해주세요");
        }
        this.carName = carName;
        this.location = location;
    }

    public void run(int random) {
        if (random >= 4) {
            this.location++;
        }
    }

    public int getLocation() {
        return location;
    }

    public String getCarName() {
        return carName;
    }
}
