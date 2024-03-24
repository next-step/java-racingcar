package racingcar;

public class Car {
    private String name;
    private int location;

    public Car(String name) throws Exception {
        checkCarNameLength(name);
        this.name = name;
        this.location = 0;
    }

    private void checkCarNameLength(String name) throws Exception {
        if (name.length() > 5) {
            throw new Exception("자동차 이름 길이 초과 (최대 5자)");
        }
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
    }

    public void move(int distance) {
        location += distance;
    }

}
