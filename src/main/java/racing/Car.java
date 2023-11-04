package racing;

public class Car {

    int carNumber = 0;
    int moveCount = 0;

    public Car(int carNumber){
        this.carNumber = carNumber;
    }

    public static int moveCar(Car car, int number){
        if(number >= 4){
            car.moveCount += 1;
        }
        return car.moveCount;
    }
}
