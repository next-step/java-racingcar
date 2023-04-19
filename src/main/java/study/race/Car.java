package study.race;

public class Car {

    private String name;
    private int moved = 0;

    public Car() {}

    public Car(String name) {
        this.name = validateName(name);
    }

    public void move() {
        moved++;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return moved;
    }

    private String validateName(String name) {
        if (name == null || name.trim().isEmpty() || name.length() > 5) {
            throw new IllegalStateException("자동차 이름은 1~5자만 가능합니다.");
        }
        return name;
    }

}
