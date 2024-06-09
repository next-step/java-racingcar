package racingcar.service.race.impl;

import racingcar.domain.Car;
import racingcar.service.race.RaceService;
import racingcar.view.InputView;

import java.util.List;
import java.util.Random;

public class RaceServiceImpl implements RaceService {
    private final InputView inputView;
    private static final int RANDOM_BOUNDARY = 10;
    private static final int MOVE_CONDITION = 4;
    private static final int GO = 1;
    private static final int STOP = 0;
    public RaceServiceImpl(InputView inputView) {
        this.inputView = inputView;
    }
    public int getRaceTryCount(){
        int tryCount;
        while(true){
            try{
                tryCount = inputView.inputInt();
                if(tryCount <= 0) throw new IllegalArgumentException("비정상적인 숫자입니다.");
                return tryCount;
            }catch (IllegalArgumentException e){
                System.out.println("[ERROR]" + e);
            }
        }
    }
    private int randomValue(){
        Random random = new Random();
        return random.nextInt(RANDOM_BOUNDARY);
    }
    private int moveNumber(int randomValue){
        if(randomValue >= MOVE_CONDITION ) return GO;
        return STOP;
    }
    public void raceStart(List<Car> cars, int tryCount){
        for(int i = 0; i < tryCount; ++i){
            for(Car car: cars){
                int randomValue = this.randomValue();
                car.move(moveNumber(randomValue));
                printCar(car);
            }
            System.out.println();
        }
    }
    public void printCar(Car car){
        System.out.println(car.getName() + " : " + car.getPosition());
    }



}
