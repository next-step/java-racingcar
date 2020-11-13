package racingcar.domain;

public class Car {
    private String name;
    private int place;

    public Car(String name) {
        if (isBlank(name)) {
            throw new IllegalArgumentException("이름 형식이 잘못 되었습니다.");
        }
        
        if (!isSupportFormat(name)) {
            throw new IllegalArgumentException("이름은 5글자를 초과할 수 없습니다.");
        }

        this.name = name;
        this.place = 0;
    }

    private boolean isSupportFormat(String name) {
        return name.length() <= 5;
    }

    private boolean isBlank(String name) {
        return name == null || name.trim().isEmpty();
    }

    public void move(MovingStrategy movingStrategy) {
        if (movingStrategy.isMovable()) {
            this.place++;
        }
    }

    public CarDTO toDTO() {
        return new CarDTO(this.name, this.place);
    }

    public int getPosition() {
        return this.place;
    }

}
