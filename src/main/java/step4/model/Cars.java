package step4.model;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> cars;

    public Cars(int carCnt) {
        cars = new ArrayList<>();
        for (int i=0; i<carCnt; i++) {
            cars.add(new Car(i+1));
        }
    }

    /**
     * 자동차 인스턴스 반환
     */
    public List<Car> getCars() {
        return cars;
    }

    /**
     * 자동차 움직임 기준에 따라 조정한다.
     * @param movingStrategy
     * @return
     */
    public List<String> moveAll(MovingStrategy movingStrategy){
        List<String> result = new ArrayList<>();

        cars.forEach(car -> {
            canMoveCar(movingStrategy, result, car);
        });

        return result;
    }

    /**
     * 랜덤 숫자가 4 이상이 나오면 전진한다.
     * @param movingStrategy
     * @param result
     * @param car
     */
    private void canMoveCar(MovingStrategy movingStrategy, List<String> result, Car car) {
        if (movingStrategy.canMove()) {
            car.go();
        }

        result.add(car.getIndex() + "/" + car.getMove());
    }
}
