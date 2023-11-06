package racing.domain;

public class Car {

    private int carCount = 0;
    private int carNumber = 0;
    private int moveCount = 0;
    private int tryCount = 0;

    public Car(){

    }

    public Car(int carNumber, int tryCount, int moveCount){
        this.carNumber = carNumber;
        this.tryCount = tryCount;
        this.moveCount = moveCount;
    }

    public Car(int carCount, int tryCount){
        this.carCount = carCount;
        this.tryCount = tryCount;
    }

    public int getCarCount(){
        return carCount;
    }

    public int getTryCount(){
        return tryCount;
    }

    public int getMoveCount(Car car){
        return car.moveCount;
    }

    public int moveCar(Car car, int number){
        if(number >= 4){
            car.moveCount += 1;
        }
        return car.moveCount;
    }
}
