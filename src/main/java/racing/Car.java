package racing;

public class Car {

    private static final int CRITERION_TO_MOVE = 4;
    private int position = 0;

    public Car() {}
    public Car(int position){
        this.position = position;
    }

    public int getPosition() {
        return position;
    }
    public void setPosition(int position) {
        this.position = position;
    }

    public void move(int randomValue) {
        if (randomValue > CRITERION_TO_MOVE) {
            this.position++;
        }
    }

}
