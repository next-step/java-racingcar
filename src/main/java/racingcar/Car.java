package racingcar;

import java.util.ArrayList;

public class Car {
    private String name;
    private int position;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }
    public int getPosition() {
        return position;
    }

    public void moveOnePoint(){
        this.position += 1;
    }

    public static ArrayList<Car> decideWinner(ArrayList<Car> car){
        ArrayList<Car> winners = new ArrayList<Car>();
        int maxPosition = car.get(0).position;
        for(Car selectedCar : car){
            maxPosition = searchMaxPosition(maxPosition, selectedCar);
        }

        for(Car selectedCar : car){
            checkPositionPerCar(maxPosition, selectedCar, winners);
        }

        return winners;
    }

    public static int searchMaxPosition(int maxPosition, Car car){
        if(car.position >= maxPosition){
            return car.position;
        }
        return maxPosition;
    }

    public static void checkPositionPerCar(int maxPosition, Car car, ArrayList<Car> winners){
        if(car.position == maxPosition){
            winners.add(car);
        }
    }

}
