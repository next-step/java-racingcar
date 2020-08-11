package racing.car.model;

public class Car {

    private String name;
    private int location;

    public Car(String name, int location) {
        validateParameter(name, location);
        this.name = name;
        this.location = location;
    }

    public void go() {
        location++;
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
    }

    public void validateParameter(String name, int location) {
        if (name.length() > 5 || name.length() <= 0) {
            throw new IllegalArgumentException("이름이 올바르지 않습니다. (5자 이하)");
        }

        if (location < 0) {
            throw new IllegalArgumentException("시작 위치는 0이상이어야 합니다.");
        }
    }

}
