package racingcar.domain;

public class Car {
    private String name;
    private int position;

    public Car(String name) {
        if (isBlank(name)) {
            throw new IllegalArgumentException("이름 형식이 잘못 되었습니다.");
        }
        
        if (!isSupportFormat(name)) {
            throw new IllegalArgumentException("이름은 5글자를 초과할 수 없습니다.");
        }

        this.name = name;
        this.position = 0;
    }

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    private boolean isSupportFormat(String name) {
        return name.length() <= 5;
    }

    private boolean isBlank(String name) {
        return name == null || name.trim().isEmpty();
    }

    public void move(MovingStrategy movingStrategy) {
        if (movingStrategy.isMovable()) {
            this.position++;
        }
    }

    public CarDTO toDTO() {
        return new CarDTO(this.name, this.position);
    }

    public int getPosition() {
        return this.position;
    }

    public boolean isPosition(int maxPosition) {
        return this.position == maxPosition;
    }

    public int greaterThan(int maxPosition) {
        if (this.position > maxPosition) {
            return this.position;
        }
        return maxPosition;
    }
}
