package kr.co.techmoa.carracing.service;

import kr.co.techmoa.carracing.model.Car;

import java.util.ArrayList;
import java.util.List;

public class CarWinCheckService {

    public List<Car> checkGameResult(List<Car> cars) {
        int max = cars.get(0).getPosition().getCoordinate();
        for(int i= 1; i < cars.size(); i++) {
            max = maxExtract(cars , i , max);
        }
        return checkMax(cars, max);
    }

    private int maxExtract(List<Car> cars, int order , int max) {
        int current= cars.get(order).getPosition().getCoordinate();
        if(current>= max){
            return current;
        }
        return max;
    }

    private List<Car> checkMax(List<Car> cars , int max) {
        List<Car> winList = new ArrayList<>();
        for(Car car : cars) {
            if(car.getPosition().getCoordinate() == max) {
                winList.add(car);
            }
        }
        return winList;
    }
}
