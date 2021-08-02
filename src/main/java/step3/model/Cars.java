package step3.model;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> cars;

    public Cars(int carCnt) {
        cars = new ArrayList<>();
        for (int i=0; i<carCnt; i++) {
            cars.add(new Car());
        }
    }

    /**
     * 자동차 총대수 반환
     */
    public int getCarCnt() {
        return cars.size();
    }

    /**
     * 자동차 인스턴스 반환
     * @param i
     * @return환
     */
    public Car getCar(int i) {
        return cars.get(i);
    }

    /**
     * 자동차 움직임 조정, 랜덤 숫자를 받아 4이상이 나오면 전진한다.
     * @param carIdx
     * @param movingStrategy
     * @return
     */
    public int move(int carIdx, MovingStrategy movingStrategy){
        if (movingStrategy.canMove()){
            return getCar(carIdx).go();
        }

        return getCar(carIdx).getMove();
    }
}
