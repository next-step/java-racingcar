package com.nextstep.racingcar.domain.car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTests {
    private List<Car> carCollection;

    @BeforeEach
    public void setup() {
        carCollection = Arrays.asList(new Car(), new Car());
    }

    @DisplayName("Car 객체 리스트를 입력 받아서 일급 콜렉션 객체 생성")
    @Test
    void createCars() {
        Cars cars = Cars.create(carCollection);
        assertThat(cars).isNotNull();
    }

    @DisplayName("컬렉션 사이드 이펙트 없음")
    @Test
    void cantModifyCarCollection() {
        List<Car> carCollection = new ArrayList<>();
        carCollection.add(new Car());

        Cars cars = Cars.create(carCollection);
        carCollection.add(new Car());

        assertThat(cars.size()).isNotEqualTo(2);
    }

    @DisplayName("내부 차량들의 주행 거리를 알 수 있음")
    @Test
    void readMoveLength() {
        Cars cars = Cars.create(carCollection);

        List<MoveLength> moveLengths = cars.getMoveLengths();

        assertThat(moveLengths.get(0)).isEqualTo(MoveLength.createZero());
        assertThat(moveLengths.get(1)).isEqualTo(MoveLength.createZero());
    }

    @DisplayName("차량을 한번에 모두 움직일 수 있음")
    @Test
    void moveAllTest() {
        Cars cars = Cars.create(carCollection);
        cars.moveAll(new ForceMoveStrategy());

        List<MoveLength> moveLengths = cars.getMoveLengths();

        assertThat(moveLengths.get(0)).isEqualTo(MoveLength.createByInt(1));
        assertThat(moveLengths.get(1)).isEqualTo(MoveLength.createByInt(1));
    }

    @DisplayName("운전자이름(String) 리스트를 입력받아서 객체를 생성할 수 있음")
    @Test
    void createCarsByDriverNames() {
        List<String> driverNames = Arrays.asList("poppo", "ita");
        CarFactory carFactory = new CarFactory();
        Cars cars = Cars.createCarsByDriverNames(driverNames, carFactory);
        assertThat(cars).isNotNull();
    }
}
