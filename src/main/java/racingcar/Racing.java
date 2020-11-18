package racingcar;

import java.util.List;
import java.util.stream.Collectors;

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
        int random = (int)(Math.random()*9);

        if(random >=4){
            result = true;
        }

        return result;
    }
    
}