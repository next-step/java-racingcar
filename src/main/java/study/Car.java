package study;

public class Car {
    private int moveCount;
    private String carName;

    public Car(String carName){
        this.carName = carName;
    }

    public void move(int number){
        if(number > 4){
            this.moveCount++;
        }
    };

    public int getMoveCount() {
        return moveCount;
    }

    public String getCarName() {
        return carName;
    }
}
