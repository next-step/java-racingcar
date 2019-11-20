package racingcarNew.domain;

public class Car {

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

    public void move(boolean isMoveable){
        if(isMoveable){
            position++;
        }
    }

}
