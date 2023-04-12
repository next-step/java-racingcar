package racing;

import java.util.List;

public class Car {
    private int location = 0;
    public Car() {

    }
    public Car addCar(){
        return new Car();
    }
    public void move(int randomNumber) {
        if(randomNumber >= 4){
            this.location += 1;
        }
    }

    @Override
    public String toString() {
        return "-";
    }

    public void printLocation() {
        for (int i = 0; i < this.location; i++) {
            toString();
        }
        System.out.println();
    }
}
