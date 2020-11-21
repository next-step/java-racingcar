package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import racingcar.domain.Car;
import racingcar.domain.Scoreboard;

public class Racing {
    
    public List<Integer> moveCar(Scoreboard board){
        List<Integer> result = new ArrayList<>();
        for(int j = 0; j < board.getMove(); j++){
            List<Integer> moveResult = tryToMoveResult(board.getCars());
            result.addAll(moveResult);
        }
        return result;
    }

    public List<Integer> tryToMoveResult(List<Car> cars){
        List<Integer> result = new ArrayList<>();
        for(int k = 0; k < cars.size(); k++){
            if(tryToMove() == true){
                Car car = cars.get(k);
                car.moveLocation();
                cars.set(k, car);
            }
            result.add(cars.get(k).getLocation());
        }
        result.add(0);
        return result;
    }

    public boolean tryToMove(){
        boolean result = false;
        Random random = new Random();
        int move = random.nextInt(10);

        if(move >=4){
            result = true;
        }

        return result;
    }
    
}