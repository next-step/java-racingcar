package racingCar;

public class Position {
    public static final int INITIAL_VALUE = 1;

    private int position;

    public Position(){
        this.position = INITIAL_VALUE;
    }

    public Position(int position) {
        this.position = position;
    }

    public int getPosition(){
        return this.position;
    }

    public void increase(){
        this.position++;
    }
}
