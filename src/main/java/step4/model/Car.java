package step4.model;

import step4.RacingApp;
import step4.view.ToDash;

public class Car {
    private final int INIT_POSITION = 1;
    private int position;
    private String name;

    public Car() {
        setInitPosition();
    }

    public Car(String name) {
        setInitPosition();
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public void setInitPosition(){
        this.position = INIT_POSITION;
    }

    public void move(int movePoint){
        if(moveForward(movePoint)){
            position++;
        }
    }

    private boolean moveForward(int movePoint) {
        if(movePoint < 0){
            throw new IllegalArgumentException("0 보다 작은수");
        }
        return movePoint >= RacingApp.MOVE_BOUNDARY;
    }

    @Override
    public String toString() {
        return this.getName()+" "+ToDash.positionToDash(position);
    }
}
