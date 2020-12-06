package racingCar.domain;

public class Car implements Comparable<Car> {
    private Position curPosition;
    private String name;

    public Car(String name) {
        this.name = name;
        curPosition = new Position();
    }

    public void racing(int randomValue, MoveStrategy moveStrategy) {
        if(moveStrategy.isMove(randomValue)) {
            curPosition.move();
        }
    }

    public Position getPosition() {
        return curPosition;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        int i = 0;
        String result = this.name + " : ";
        while(i < curPosition.getPosition()) {
            result += "-";
            i++;
        }
        return result;
    }

    @Override
    public int compareTo(Car o) {
        return this.curPosition.compareTo(o.curPosition);
    }
}
