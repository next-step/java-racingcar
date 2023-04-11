package racing;

import java.util.List;

public class Car {
    private int location = 0;
    public Car() {

    }
    public void addCar(List<Car> carList) {
        carList.add(new Car());
    }
    public void move() {
        this.location += 1;
    }
    public int returnLocation() {
        return this.location;
    }
    public void print(int printCount){
        for (int i = 0; i < printCount; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
