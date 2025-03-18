package racing;

import static java.lang.System.*;

import java.util.HashMap;

/**
 * 자동차 그룹 클래스
 */
public class CarGroup {
    protected HashMap<Integer, Car> cars;
    public StringBuilder stringBuilder;

    public CarGroup(HashMap<Integer, Car> cars) {
        this.cars = cars;
    }

    /**
     * 자동차 단체 이동 메서드
     */
    public void go() {
        for (int i=0; i<cars.size(); i++) {
            cars.get(i).move();
        }
    }

    /**
     * 자동차 그룹 위치 출력 메서드
     */
    public void printPosition() {
        stringBuilder = new StringBuilder();
        for (int i=0; i<cars.size(); i++) {
            stringBuilder.append(cars.get(i).print()).append("\n");
        }
        out.println(stringBuilder.toString());
    }
}
