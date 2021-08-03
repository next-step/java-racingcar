package kr.co.techmoa.carracing.service;

import kr.co.techmoa.carracing.model.Car;

import java.util.ArrayList;
import java.util.List;

public class CarWinCheckService {

    public List<Car> checkGameResult(List<Car[]> rounds) {
        Car[] cars = rounds.get(rounds.size()-1);

        int max = cars[0].getTotalMove();

        for(int i = 1 ; i < cars.length;i++) {
            if(cars[i].getTotalMove() >= max) {
                max = cars[i].getTotalMove();
            }
        }

        return compare(cars, max);
    }

    private List<Car> compare(Car[] cars , int max) {
        List<Car> winList = new ArrayList<>();
        for(Car car : cars) {
            if(car.getTotalMove() == max) {
                winList.add(car);
            }
        }
        return winList;
    }
}
