package racing;

public class Car {

    private int position = 0;

    public Car() {
    }

    public Car(int initPosition) {
        this.position = initPosition;
    }

    public int valueOfCurrentPosition() {
        return position;
    }

    public int race(int randomNumber) {
        if(randomNumber > 3) {
            position++;
        }
        return position;
    }
}
