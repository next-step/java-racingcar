package carracing.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Winners
 * description 경기에 참가한 차량 중 우승자 리스트
 * version 0.0.4
 *
 * history
 *  0.0.1) 클래스 신규생성
 */
public class Winners {

    private final List<Car> carList;

    public Winners(List<Car> carList) {
        this.carList = carList;
    }

    public List<String> nameList() {
        List<String> nameList = new ArrayList<>();
        for (Car car : carList) {
            nameList.add(car.name());
        }
        return nameList;
    }
}
