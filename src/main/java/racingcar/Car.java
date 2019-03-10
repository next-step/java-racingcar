package racingcar;

public class Car {
    private int position = 0;

    public int getPosition() {
        return position;
    }

    public void moveCar(int randomValue) {
        if(randomValue >= 4)
            this.position++;
    }
}