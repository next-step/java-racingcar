package racingcar;

import java.util.Arrays;
import java.util.stream.Stream;

public class CarGroup {

    /**
     * NOTE: 기본 배열을 사용한 이유
     * ArrayList, LinkedList, HashMap, Set 등등 자바의 자료구조를 공부했으나,
     * 현재 요구사항에서는 자동차의 추가, 수정, 삭제 및 검색 기능이 필요치 않으므로,
     * 성능 향상을 위해 기본 배열만으로 충분하다고 판단했다.
     */
    private Car[] carArr;

    public CarGroup(String nameCsv, MoveStrategy strategy) {
        String[] nameArr = nameCsv.split(CarGroupConst.NAME_SPLIT_REGEX);
        int carNum = nameArr.length;
        Car[] carArr = new Car[carNum];
        for (int i = 0; i < carNum; i++) {
            carArr[i] = new Car(nameArr[i], strategy);
        }
        this.carArr = carArr;
    }

    public int getCarNum() {
        return this.carArr.length;
    }

    public void moveCar(int carIdx) {
        this.carArr[carIdx].move();
    }

    public Stream<Car> getCarStream() {
        return Arrays.stream(this.carArr);
    }
}
