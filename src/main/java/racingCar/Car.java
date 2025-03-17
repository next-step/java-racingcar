package racingCar;

public class Car {
    private static final int CONDITION = 4;
    private int position;

    public int getPosition() {
        return position;
    }

    public void move() {
        if (NumberRandomizer.generate() >= CONDITION) {
            position += 1;
        }
    }

    // 테스트용: 랜덤 숫자를 직접 주입할 수 있는 메서드
    public void move(int randomNumber) {
        if (randomNumber >= CONDITION) {
            position += 1;
        }
    }
}

