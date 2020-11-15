package racingcar;

import java.util.List;

public class RacingGame {
    //counts, attempts
    //private int counts;
    private final Cars cars;
    private final RacingDTO racingDTO;

    public RacingGame(RacingDTO racingDTO){
        this.racingDTO = racingDTO;
        this.cars = new Cars(this.racingDTO.getNames());
    }

    public Cars getCars(){
        return this.cars;
    }

    //자동차 경주 진행 지시
    public void instructMove(Car car){
        MoveChecker moveChecker = new MoveChecker();
        for(int i=0;i<this.racingDTO.getAttempts();i++){
            moveChecker.moveAndStop(car);
        }
    }

    //경기 시작  :
    public void start(){
        for(int i=0;i<this.racingDTO.getNames().length;i++){
            instructMove(this.cars.oneOfCars(i));
        }

    }

    //경기 결과
    public List<String> end(){
        return cars.findWinner();
    }


}
