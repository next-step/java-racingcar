package step4.model;

import step4.RacingApp;
import step4.view.ToDash;

public class Car implements Comparable<Car>{
    private final int INIT_POSITION = 0;
    private String name;
    private int position;

    public Car() {
        setInitPosition();
    }

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public Car(String name) {
        if(isBlank(name)){
            throw new IllegalArgumentException("차 이름이 비어있습니다.");
        }
        if(name.length()>5){
            throw new IllegalArgumentException("차 이름 5글자 초과!");
        }
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
        return this.getName()+" : "+ToDash.positionToDash(position);
    }

    @Override
    public int compareTo(Car car) {
        return Integer.compare(this.getPosition(),car.getPosition());
    }

    private boolean isBlank(String name){
        return "".equals(name) ? true : false;
    }
}
