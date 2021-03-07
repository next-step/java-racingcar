package racingcar.model;

public class Car {
    private int position = 0;
    private int carNum = 0;

    public Car(int num) {
        this.carNum = num;
    }

    public int getPosition() {
        return position;
    }

    public int getCarNum() {
        return carNum;
    }

    public void move(){
        position++;
    }
}
