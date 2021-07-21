package step3.model;

public class Car {

    private final int INIT_POSITION = 0;

    private int position;

    public Car() {
        position = INIT_POSITION;
    }

    public int getPosition() {
        return position;
    }

    public void move(boolean move){
        if(move){
            position++;
        }
    }
}
