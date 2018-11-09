package racingcar;

import java.util.List;

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

    public static int searchMaxPosition(int maxPosition, Car car){
        if(car.position >= maxPosition){
            return car.position;
        }
        return maxPosition;
    }

    public static void checkPositionPerCar(int maxPosition, Car car, List<Car> winner) {
        if(car.position == maxPosition){
            winner.add(car);
        }
    }

}
