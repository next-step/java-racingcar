package domain;

import view.InputView;
import view.ResultView;

import java.util.*;

public class RacingGame {
    private static final int MAX_NUM = 10;

    private int time;
    private List<Car> cars;

    public RacingGame(String[] names, int time){
        readyCar(names);
        this.time = time;
    }

    public RacingGame(List<Car> cars, int time){
        this.cars = cars;
        this.time = time;
    }

    private List<Car> readyCar(String[] names) {
        cars = new ArrayList<>();
        for(int i = 0; i < names.length; i ++){
            cars.add(new Car(names[i]));
        }
        return cars;
    }

    public int getCarCount(){
        return cars.size();
    }

    public String getName(int index){
        return cars.get(index).getName();
    }

    public int getTime(){
        return time;
    }

    public List<Car> move() {
        List<Car> nextStepCars = new ArrayList<>();
        for(int i = 0; i < cars.size(); i++){
             nextStepCars.add(tryMove(cars.get(i)));
        }
        this.cars = nextStepCars;
        return cars;
    }

    public List<Car> getCars(){
        return cars;
    }

    private Car tryMove(Car car) {
        return car.addPosition(getRandomNum());
    }

    private int getRandomNum() {
        Random random = new Random();
        return random.nextInt(MAX_NUM);
    }





}
