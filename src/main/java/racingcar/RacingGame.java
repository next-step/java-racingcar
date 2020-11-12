package racingcar;

import java.util.List;
import java.util.Map;

public class RacingGame {
    //counts, attempts
    //private int counts;
    private String[] names;
    private int attempts;
    private Cars cars;

    public RacingGame(RacingDTO racingDTO){
        this.names = racingDTO.getNames();
        this.attempts = racingDTO.getAttempts();
        this.cars = new Cars(this.names);
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
        for(int i=0;i<this.names.length;i++){
            instructMove(this.getCars().get(i));
        }

    }

    //경기 결과
    public List<String> end(){
        return cars.findWinner();
    }


}
