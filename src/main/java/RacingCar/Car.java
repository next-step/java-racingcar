package RacingCar;

import java.util.ArrayList;

public class Car {

    private int location;
    private String name;
    private static final int FORWARD_NUM = 4;
    private static final int LIMIT_NUM = 5;

    public Car(int location, String name) {
        if (name.length() > LIMIT_NUM) throw new IllegalArgumentException(name + "의 자동차 이름은"+ LIMIT_NUM+ "자 이하여야 합니다.");

        this.location = location;
        this.name = name;
    }

    public int getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public void move(int randomNumber) {
        if (randomNumber >= FORWARD_NUM)
            this.location++;
    }

    public String chooseWinner(ArrayList<Car> cars) {
        if (isWinner(getMaxLocation(maxLocation(cars))))
            return name;

        return "";
    }

    boolean isWinner(int maxLocation) {
        if (this.location == maxLocation)
            return true;

        return false;
    }

    private int getMaxLocation(int location) {
        if (this.location > location)
            return this.location;

        return location;
    }

    private int maxLocation(ArrayList<Car> cars) {
        int maxLocation = 0;
        for (Car car : cars)
            maxLocation = car.getMaxLocation(maxLocation);

        return maxLocation;
    }

}
