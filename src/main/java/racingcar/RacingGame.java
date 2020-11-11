package racingcar;

import java.util.List;
import java.util.Map;

public class RacingGame {
    //counts, attempts
    private int counts;
    private int attempts;
    private Cars cars;

    public RacingGame(RacingDTO racingDTO){
        this.counts = racingDTO.getCounts();
        this.attempts = racingDTO.getAttempts();
        this.cars = new Cars(this.counts);
    }

    //리스트 형태로 car List 내보내기
    public List<Car> getCars() {
        List<Car> carList = this.cars.getCarList();
        return carList;
    }


    //자동차 경주 진행 지시
    public void instructMove(Car car){
        MoveCheckor moveCheckor = new MoveCheckor();
        for(int i=0;i<this.attempts;i++){
            moveCheckor.moveAndStop(car);
        }
    }

    //경기 시작
    public void start(){
        for(int i=0;i<this.counts;i++){
            instructMove(this.getCars().get(i));
        }

    }


}
