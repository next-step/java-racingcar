package racingGame.Business;

import java.util.ArrayList;
import racingGame.model.Car;

public class Process {
    
    private ArrayList<Car> cars;
    
    public void run(int cars, int moves){
        init(cars, moves);
        
    }
    
    private void init(int cars, int moves) {
        generateCar(cars);
        setMoveCount(moves);
    }
    
    private void generateCar(int num){
        if(num < 1) {
            throw new IllegalArgumentException("참가시킬 자동차 수 입력이 생략되거나, 0이하");
        }
    }
    
    private void setMoveCount(int moves) {
        if(moves < 1) {
            throw new IllegalArgumentException("이동횟수에 입력이 생략되거나, 0이하");
        }
    }
}