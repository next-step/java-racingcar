package carracing.domain.carracing;

import java.util.ArrayList;
import java.util.List;

public class CarsMoveStatusHistory {
    /**
     * 자동차 경주(CarRacing)의 moveTryCount 갯수만큼 생성되어야 한다.
     */
    private final List<Cars> carsByMoveTryCount;

    public CarsMoveStatusHistory() {
        this.carsByMoveTryCount = new ArrayList<>();
    }

    public void save(Cars cars) {
        this.carsByMoveTryCount.add(cars.deepCopy());
    }

    public int moveTryCount() {
        return this.carsByMoveTryCount.size();
    }

    /**
     * @param moveTryStep 이동시도 횟수 중 얻고자 하는 단계 (값은 0부터 시작한다.)
     */
    public Cars getCarsByMoveTryStep(int moveTryStep) {
        return this.carsByMoveTryCount.get(moveTryStep);
    }
}
