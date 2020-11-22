package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import racingcar.domain.Car;
import racingcar.domain.Scoreboard;

public class Racing {
    
    public List<String> moveCar(Scoreboard board){
        List<String> result = new ArrayList<>();
        for(int j = 0; j < board.getMove(); j++){
            List<String> moveResult = tryToMoveResult(board.getCars(), board.getMove());
            result.addAll(moveResult);
        }
        return result;
    }

    public List<String> tryToMoveResult(List<Car> cars, int move){
        List<String> result = new ArrayList<>();
        for(int k = 0; k < cars.size(); k++){
            if(tryToMove()){
                Car car = cars.get(k);
                car.moveLocation();
                cars.set(k, car);
            }
            result.add(cars.get(k).getCar()+" : "+String.valueOf(cars.get(k).getLocation()) +" : "+ String.valueOf(move));
        }
        result.add("");
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