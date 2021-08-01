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
     * 자동차 인스턴스 반
     * @param i
     * @return환
     */
    public Car getCar(int i) {
        return cars.get(i);
    }

    /**
     * 랜덤 숫자를 기준으로 움직일수 있는지 판단해서 자동차를 움직인다.
     * @param carIdx
     * @param randomNum
     */
    public int canMove(int carIdx, int randomNum) {
        //4미만일때는 시도횟수만줄임
        if (randomNum < 4) {
            return getCar(carIdx).getMove();
        }

        //4이상일때는 전진하고 시도횟수 줄임
        return getCar(carIdx).go();
    }
}
