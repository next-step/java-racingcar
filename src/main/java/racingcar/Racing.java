package racingcar;

import java.util.ArrayList;
import java.util.Random;

public class Racing {
    private ArrayList<Car> carsList;
    private int stages;

    public Racing(ArrayList<Car> carsList, int stages){
        this.carsList = carsList;
        this.stages = stages;
    }

    public void start(){
        for(int current = stages; current > 0; --current){
            moveCars();
            InputOutput.printCurrentCarsState(carsList);
        }
    }

    public void moveCars() {
        for(Car car : carsList){
            decideMove(car);
        }
    }

    public void decideMove(Car car) {
        if(getRandomNumber() >= 4){
            car.moveForward();
        }
    }

    public int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(10);
    }
}
