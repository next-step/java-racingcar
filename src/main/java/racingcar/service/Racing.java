package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import racingcar.domain.Car;
import racingcar.domain.Scoreboard;

public class Racing {
    
    public Scoreboard moveCar(Scoreboard board){
        for(int j = 0; j < board.getMove(); j++){
            board = tryToMoveResult(board, j);
        }
        return board;
    }

    public Scoreboard tryToMoveResult(Scoreboard board, int j){
        List<Integer> result = new ArrayList<>();
        for(int k = 0; k < board.getRacingCar().getCars().size(); k++){
            if(tryToMove()){
                Car car = board.getRacingCar().getCars().get(k);
                car.moveLocation();
                board.getRacingCar().getCars().set(k, car);
            }
            result.add(board.getRacingCar().getCars().get(k).getLocation());
        }
        board.getHistory().putRacingResult(j, result);

        return board;
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
