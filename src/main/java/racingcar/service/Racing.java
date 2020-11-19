package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import racingcar.domain.Car;
import racingcar.domain.Scoreboard;

public class Racing {
    
    public List<Scoreboard> moveCar(Scoreboard board){
        List<Scoreboard> result = new ArrayList<>();
        for(int j = 0; j < board.getMove(); j++){
            tryToMoveResult(board.getCars());
            result.add(board);
        }
        return result;
    }

    public void tryToMoveResult(final List<Car> cars){
        for(int k = 0; k < cars.size(); k++){
            if(tryToMove() == true){
                final Car car = cars.get(k);
                car.moveLocation();
                cars.set(k, car);
            }
        }
    }

    public boolean tryToMove(){
        boolean result = false;
        final Random random = new Random();
        final int move = random.nextInt(10);

        if(move >=4){
            result = true;
        }

        return result;
    }
    
}