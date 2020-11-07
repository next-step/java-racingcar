package racingcar;

import java.util.Map;

public class RacingCar {
    //counts, attempts
    private int counts;
    private int attempts;
    private Car[] car;

    public RacingCar(Map<String, Integer> inputs){
        this.counts = inputs.get("counts");
        this.attempts = inputs.get("attempts");
    }
    //Getter Methods - start
    public int getCounts(){
        return this.counts;
    }

    public int getAttempts(){
        return this.attempts;
    }

    public Car[] getCars(){
        return this.car;
    }
    //Getter Methods - end

    //경기 출전 자동차 객체 초기화
    public void readToCar(int count){
        this.car = new Car[count];
        for(int i=0;i<count;i++){
            this.car[i] = new Car();
        }
    }

    //자동차 객체별 난수 발생
    public void instructMove(){
        for(int i=0;i<this.counts;i++) {
            this.car[i].decision(this.attempts);
        }
    }

    //경기 시작
    public void start(){

        readToCar(this.counts);
        instructMove();

    }


}
