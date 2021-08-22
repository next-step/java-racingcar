package study.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.Car;
import step3.domain.Racing;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RacingTest {

    Racing racing = new Racing();

    @DisplayName("initCars 메소드 이름 1개일 때 출력 list size와 이름 테스트")
    @Test
    void initCarsTest_이름_1개() {
        String[] names = {"pobi"};
        List<Car> cars = racing.initCars(names);
        assertEquals(1, cars.size());
        assertEquals(names[0], cars.get(0).getName());
    }

    @DisplayName("initCars 메소드 이름 3개일 때 출력 list size와 이름 테스트")
    @Test
    void initCarsTest_이름_3개() {
        String[] names = {"pobi1", "pobi2", "pobi3"};
        List<Car> cars = racing.initCars(names);

        assertEquals(3, cars.size());
        assertThat(names).containsOnly(names[0], names[1], names[2]);
    }

    @DisplayName("이름 한개 split 확인")
    @Test
    void splitNamesTest_이름_1개() {
        String[] names = racing.splitNames("pobi");
        assertEquals(1, names.length);
        assertEquals("pobi", names[0]);
    }

    @DisplayName("이름 3개 split 확인")
    @Test
    void splitNamesTest_이름_3개() {
        String[] names = racing.splitNames("pobi1,pobi2,pobi3");
        assertEquals(3, names.length);
        assertEquals("pobi1", names[0]);
        assertEquals("pobi2", names[1]);
        assertEquals("pobi3", names[2]);
    }

    @DisplayName("자동차 거리가 모두 다를 경우 우승자 1명 확인")
    @Test
    void getWinner_우승자_1명() {
        List<Car> cars = new ArrayList<>();

        // distance = 3
        Car car = new Car("winner", 4);
        car.move(5);
        car.move(5);
        car.move(5);
        cars.add(car);

        // distance = 1
        car = new Car("pobi1", 4);
        car.move(5);
        cars.add(car);

        // distance = 0
        car = new Car("pobi2", 4);
        cars.add(car);

        List<String> winner = racing.getWinner(cars);

        assertEquals(1, winner.size());
        assertEquals("winner", winner.get(0));
    }

    @DisplayName("자동차 거리가 2명이 같을 경우 우승자 2명 확인")
    @Test
    void getWinner_우승자_2명() {
        List<Car> cars = new ArrayList<>();

        // distance = 1
        Car car = new Car("pobi", 4);
        car.move(5);
        cars.add(car);

        // distance = 2
        car = new Car("winner1", 4);
        car.move(5);
        car.move(5);
        cars.add(car);

        // distance = 2
        car = new Car("winner2", 4);
        car.move(5);
        car.move(5);
        cars.add(car);

        List<String> winners = racing.getWinner(cars);

        assertEquals(2, winners.size());
        assertThat(winners).containsExactlyInAnyOrder("winner1", "winner2");
    }

    @DisplayName("startRace 메소드 실행 테스트")
    @Test
    void startRaceTest() {
        String[] names = {"pobi1", "pobi2", "pobi3"};
        racing.startRace(racing.initCars(names));
    }
}
