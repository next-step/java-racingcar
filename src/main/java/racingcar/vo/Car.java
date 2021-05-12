package racingcar.vo;

public class Car {
    private String name;
    private int location;

    public Car(String name, int location) {
        this.name = name;
        this.location = location;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocationInfo(int location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public int getLocationInfo() {
        return location;
    }
}
