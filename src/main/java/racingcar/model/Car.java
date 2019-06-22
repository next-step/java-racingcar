package racingcar.model;

public class Car {
    private int position;

    public Car(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public int addPosition(){
        return this.position += 1;
    }

}

