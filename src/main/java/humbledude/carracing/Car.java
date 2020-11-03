package humbledude.carracing;

public class Car {

    private String name = "car";
    private int position = 0;

    public Car() {}

    public Car(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 초과하지 않게 지정해야 합니다.");
        }
        this.name = name;
    }

    public void accelerate(int fuel) {
        if (fuel >= 4) {
            this.position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
