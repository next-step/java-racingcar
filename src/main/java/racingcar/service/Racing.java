package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import racingcar.domain.Car;
import racingcar.domain.Scoreboard;

public class Racing {
    public static final int MOVE = 4;
    
    public Scoreboard moveCar(Scoreboard board){
        for(int j = 0; j < board.getMove(); j++){
            board = tryToMoveResult(board, j);
        }
        return board;
    }

    public Scoreboard tryToMoveResult(Scoreboard board, int j){
        List<Integer> result = new ArrayList<>();
        for(int k = 0; k < board.getRacingCar().getCars().size(); k++){
            tryToMove(board, k, randomMove());
            result.add(board.getRacingCar().getCars().get(k).getLocation());
        }
        board.getHistory().putRacingResult(j, result);

        return board;
    }

    public Scoreboard tryToMove(Scoreboard board, int k, int tryMove){
        if (tryMove >= MOVE) {
            Car car = board.getRacingCar().getCars().get(k);
            car.moveLocation();
        }
        return board;
    }
    
    public int randomMove(){
        Random random = new Random();
        int move = random.nextInt(10);

        return move;
    }
    
}
