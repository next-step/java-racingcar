package racing;

public class Car {
    private String carName;
    private int position;

    public Car(String carName) {
        checkCarName(carName);
        this.carName = carName;
    }

    public void checkCarName(String carName) {
        if (carName.isEmpty()) {
            throw new IllegalArgumentException("이름이 비어있습니다. 이름을 모두 입력해주세요.");
        }
    }

    public void move(CarMoveBehavior carMoveBehavior) {
        if (carMoveBehavior.action()) {
            position++;
        }
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }
}
