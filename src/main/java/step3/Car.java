package step3;

import java.util.ArrayList;

public class Car {

    private int currentPosition;

    public int moveForward(boolean success){
        if(success){
            currentPosition++;
        }
        return currentPosition;
    }

    public int getCurrentPosition(){
        return currentPosition;
    }

}