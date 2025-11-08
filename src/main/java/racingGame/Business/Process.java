package racingGame.Business;

import java.util.ArrayList;
import racingGame.model.Car;
import racingGame.util.RandomUtil;

public class Process {
    
    public static final int CAR_FORWARD_CRITERIA = 3;
    private final ArrayList<Car> cars = new ArrayList<>();
    private int moves = 0;
    
    public void run(int cars, int moves){
        init(cars, moves);
        for(int i = 0; i < moves; i++) {
            nextMove();
        }
    }
    
    private void nextMove() {
        for(Car car: cars) {
            if(RandomUtil.generateInt() > CAR_FORWARD_CRITERIA) {
                car.move();
            }
        }
    }
    
    public ArrayList<Car> joinCars() {
        return this.cars;
    }
    
    public int nowMove() {
        return this.moves;
    }
    
    private void init(int cars, int moves) {
        generateCar(cars);
        setMoveCount(moves);
    }
    
    private void generateCar(int num){
        if(num < 1) {
            throw new IllegalArgumentException("참가시킬 자동차 수 입력이 생략되거나, 0이하");
        }
        for(int i = 0; i < num; i++) {
            Car car = new Car();
            car.init();
            cars.add(car);
        }
    }
    
    private void setMoveCount(int moves) {
        if(moves < 1) {
            throw new IllegalArgumentException("이동횟수에 입력이 생략되거나, 0이하");
        }
        this.moves = moves;
    }
}