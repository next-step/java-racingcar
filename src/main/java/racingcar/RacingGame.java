package racingcar;

import java.util.List;

public class RacingGame {
    private final RacingDTO racingDTO;

    public RacingGame(RacingDTO racingDTO){
        this.racingDTO = racingDTO;

    }

    //자동차 경주 진행 지시
    public void instructMove(Car car){
        for(int i=0;i<racingDTO.getAttempts();i++){
            car.move();
            car.recordDistance();
        }
    }

    //경기 시작
    public void start(){
        for(int i=0;i<racingDTO.getNames().length;i++){
            instructMove(racingDTO.getCars().oneOfCars(i));
        }
    }

    //경기 종료
    public List<String> end(){
        return racingDTO.getCars().findWinner();
    }


}
