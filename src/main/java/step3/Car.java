package step3;

import java.util.ArrayList;

public class Car {

    private int currentPosition;

    public void moveForward(){
        currentPosition++;
    }

    public int getCurrentPosition(){
        return currentPosition;
    }

}