package car_racing.domain.model;

public class Car {
    private final Name name;
    private Integer distance = 0;

    public Car(String name) {
        this.name = new Name(name);
    }

    public void move(int distance) {
        if (distance < 0) throw new IllegalArgumentException("자동차는 음수만큼 움직일 수 없습니다.");
        this.distance += distance;
    }

    public String getName() {
        return this.name.getName();
    }

    public int getDistance() {
        return distance;
    }
}
