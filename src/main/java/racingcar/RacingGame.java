package racingcar;

import java.util.List;

public class RacingGame {
    private final RacingDTO racingDTO;
    private final Cars cars;

    public RacingGame(RacingDTO racingDTO){
        this.racingDTO = racingDTO;
        this.cars = Cars.of(racingDTO.getNames());
    }

    public Cars getCars(){
        return cars;
    }

    //자동차 경주 진행 지시
    public void instructMove(Car car){
        for(int i=0;i<racingDTO.getAttempts();i++){
            car.move();
            car.recordDistance();
        }
    }

    //경기 시작  :
    public void start(){
        for(int i=0;i<racingDTO.getNames().length;i++){
            instructMove(cars.oneOfCars(i));
        }

    }

    //경기 결과
    public List<String> end(){
        return cars.findWinner();
    }


}
