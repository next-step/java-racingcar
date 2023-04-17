package racingcar.model;

import java.util.List;

import static racingcar.model.RandomNum.getRandomNum;

public class CarRace {

    private final static int MOVE_DISTANCE = 4;

    public static List<Car> moveCar(List<Car> carList){
        for(Car car : carList){
            int randomNum = getRandomNum();
            if(isCanMove(randomNum)){
                moveCar(car);
            }
        }
        return carList;
    }

    public static void moveCar(Car car){
        car.move();
    }

    public static boolean isCanMove(int num){
        if(num >= MOVE_DISTANCE){
            return true;
        }
        return false;
    }

}
