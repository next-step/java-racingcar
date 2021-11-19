package step4.domain;


import step4.exception.RacingGameInputException;

public class Car {
    private String name;
    private int currentPosition;

    public Car(String name) {
        validateCarName(name);
        this.name = name;
        this.currentPosition = 0;
    }

    public void move(int distance) {
        currentPosition += distance;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public String getName(){
        return name;
    }

    private void validateCarName(String carName) {
        if (carName.length() > 5) {
            throw new RacingGameInputException("5자 이하의 자동차 이름을 입력하세요");
        }
    }
}
