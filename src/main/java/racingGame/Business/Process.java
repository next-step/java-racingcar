package racingGame.Business;

import java.util.ArrayList;
import racingGame.model.Car;

public class Process {
    
    private ArrayList<Car> cars;
    
    public void run(int cars, int moves){
        generateCar(cars);
    }
    
    private void generateCar(int num){
        if(num < 1) {
            throw new IllegalArgumentException("참가시킬 자동차 수 입력이 생략되거나, 0이하");
        }
    }
}