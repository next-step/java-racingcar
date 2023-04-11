package racing;

import java.util.List;

public class Car {
    private int location = 0;
    public Car() {

    }
    public void addCar(List<Car> carList) {
        carList.add(new Car());
    }
    public void move(int randomNumber) {
        if(randomNumber >= 4){
            this.location += 1;
        }
    }
    public void printLocation() {
        for (int i = 0; i < this.location; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
