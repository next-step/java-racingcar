package racingcar.service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import racingcar.domain.Car;
import racingcar.domain.Scoreboard;
import racingcar.view.ResultView;

public class Racing {
    ResultView resultView = new ResultView();
    
    public void moveCar(Scoreboard board){
        for(int j = 0; j < board.getMove(); j++){
            tryToMoveResult(board.getCars());
            resultView.racingResult(board.getCars()
                                    .stream().map(Car::getLocation)
                                    .collect(Collectors.toList()));
        }
    }

    public void tryToMoveResult(List<Car> cars){
        for(int k = 0; k < cars.size(); k++){
            if(tryToMove() == true){
                Car car = cars.get(k);
                car.moveLocation();
                cars.set(k, car);
            }
        }
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