package racingGame.Business;

import java.util.ArrayList;
import racingGame.model.Car;
import racingGame.util.RandomUtil;

public class Process {
    
    private final ArrayList<Car> cars = new ArrayList<>();
    private int moves = 0;
    
    public void run(int cars, int moves){
        init(cars, moves);
        proceed();
    }
    
    private void proceed() {
        for(int i = 0; i < moves; i++) {
            nextMove();
        }
    }
    
    private void nextMove() {
        for(Car car: cars) {
            forward(car);
        }
    }
    
    private void forward(Car car) {
        if(RandomUtil.generateInt() > 3) {
            car.move();
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