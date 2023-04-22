package step3;

import java.util.ArrayList;
import java.util.List;

public class Car {

    private int goCount;
    private static List<Car> cars = new ArrayList<>();
    public static List<Car> createCars(int num){
        for(int i=0; i<num; i++){
            cars.add(new Car());
        }
        return cars;
    }

    public Car() {
        this.goCount = 0;
    }

    public int getGoCount() {
        return goCount;
    }

    public void addGoCount() {
        this.goCount++;
    }

}
