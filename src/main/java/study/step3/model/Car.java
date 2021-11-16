package study.step3.model;

import study.step3.strategy.MoveCar;

/**
 * 차량 클래스
 */
public class Car {
    private static final String MOVE_CHARACTER = "-";
    private static final int START_LOCATION = 0;

    private int location;

    /**
     * 생성자
     */
    public Car() {
        this(START_LOCATION);
    }

    /**
     * 생성자
     * @param location 차량 위치
     */
    public Car(int location) {
        this.location = location;
    }

    /**
     * 차량 이동
     * @return
     */
    public void moveCar(MoveCar moveCar){
        if(moveCar.isMove()){
            this.location++;
        }
    }

    /**
     * 자동차 위치 조회
     * @return 자동차 위치
     */
    public int getCarLocation(){
        return this.location;
    }
}
