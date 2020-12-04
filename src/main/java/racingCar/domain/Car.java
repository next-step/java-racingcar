package racingCar.domain;

public class Car {
    private Position curPosition;

    public Car() {
        curPosition = new Position();
    }

    public void racing(int randomValue) {
        Condition condition = Condition.CheckCondition(randomValue);
        curPosition.move(condition);
    }

    public int getPosition() {
        return curPosition.getPosition();
    }

    @Override
    public String toString() {
        int i = 0;
        String result = "";
        while(i < curPosition.getPosition()) {
            result += "-";
            i++;
        }
        return result;
    }
}
