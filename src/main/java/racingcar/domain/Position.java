package racingcar.domain;

public class Position {

    private static final int START_INIT_VALUE = 1;
    private int currentPosition;

    public Position(){
        currentPosition = START_INIT_VALUE;
    }

    public void addOnePosition(){
        ++currentPosition;
    }

    public int getPosition(){
        return currentPosition;
    }
}
