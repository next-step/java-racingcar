package kr.co.techmoa.carracing.service;

import kr.co.techmoa.carracing.model.Car;

import java.util.ArrayList;
import java.util.List;

public class CarWinCheckService {

    public List<Car> checkGameResult(List<Car[]> rounds) {
        Car[] togetherCars = rounds.get(rounds.size()-1);
        int max = togetherCars[0].getTotalMove();
        for(int i = 1 ; i < togetherCars.length;i++) {
            max = maxCheck(togetherCars, i, max);
        }
        return compare(togetherCars, max);
    }

    private int maxCheck(Car[] togetherCars, int order , int max) {
        if(togetherCars[order].getTotalMove() >= max) {
            max = togetherCars[order].getTotalMove();
        }
        return max;
    }

    private List<Car> compare(Car[] togetherCars , int max) {
        List<Car> winList = new ArrayList<>();
        for(Car car : togetherCars) {
            if(car.getTotalMove() == max) {
                winList.add(car);
            }
        }
        return winList;
    }
}
