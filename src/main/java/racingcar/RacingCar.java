package racingcar;

import java.util.Map;

public class RacingCar {
    //counts, attempts
    private int counts;
    private int attempts;
    private Cars cars;

    public RacingCar(RacingDTO racingDTO){
        this.counts = racingDTO.getCounts();
        this.attempts = racingDTO.getAttempts();
    }

    public Cars getCars() {
        return this.cars;
    }

    //경기 출전 자동차 객체 초기화
    public void readToCar(int count){
        this.cars = new Cars(count);
    }

    //자동차 객체별 난수 발생
    public void instructMove(){
        MoveCheckor moveCheckor = new MoveCheckor();
        for(int i=0;i<this.counts;i++) {
            moveCheckor.moveAndStop(this.cars.getCars().get(i),this.attempts );

        }
    }

    //경기 시작
    public void start(){

        readToCar(this.counts);
        instructMove();

    }


}
