package racingcar.domain.racing;

import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.domain.move.MoveStrategy;
import racingcar.domain.move.RandomMoveStrategy;

public class RacingGame {
    private final RacingDTO racingDTO;
    private final Cars cars;

    public RacingGame(RacingDTO racingDTO){
        this.racingDTO = racingDTO;
        this.cars = Cars.of(racingDTO.getNames());
    }

    //자동차 경주 진행 지시
    public void instructMove(Car car){


        for(int i=0;i<racingDTO.getAttempts();i++){
            MoveStrategy randomMoveStrategy = new RandomMoveStrategy();
            car.move(randomMoveStrategy);

        }
    }

    //경기 시작
    public void start(){
        for(int i=0;i<cars.getPlayerNumber();i++){
            instructMove(cars.oneOfCars(i));
        }

    }

    //경기 종료
    public Cars end(){
        return cars;
    }


}
