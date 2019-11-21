package racingcarNew.domain;

public class Car {

    private static final int CAR_MOVEABLE_LIMIT_NUMBER = 4;
    private String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getCarName() {
        return this.name;
    }

    public int getPosition(){
        return this.position;
    }

    public void move(int randomNo){
        if(randomNo >= CAR_MOVEABLE_LIMIT_NUMBER){
            this.position++;
        }
    }
}
