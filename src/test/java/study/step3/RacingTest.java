package study.step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.Car;
import step3.domain.Racing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RacingTest {

    Racing racing;

    //Test 전 마다 매번 실행된다.
    @BeforeEach
    public void initialize() {
        racing = new Racing(new Random());
    }

    @DisplayName("initCars 메소드 이름 1개일 때 출력 list size와 이름 테스트")
    @Test
    void initRace_이름_1개() {
        racing.initRace("pobi");
        List<Car> cars = racing.getCars();
        assertEquals(1, cars.size());
        assertEquals("pobi", cars.get(0).getName());
    }

    @DisplayName("initCars 메소드 이름 3개일 때 출력 list size와 이름 테스트")
    @Test
    void initRace_이름_3개() {
        racing.initRace("pobi1,pobi2,pobi3");
        List<Car> cars = racing.getCars();

        List<String> names = cars.stream().map(a -> { return a.getName(); }).collect(Collectors.toList());
        assertEquals(3, cars.size());
        assertThat(names).containsOnly("pobi1", "pobi2", "pobi3");
    }

    @DisplayName("자동차 거리가 모두 다를 경우 우승자 1명 확인")
    @Test
    void getWinner_우승자_1명() {
        List<Car> cars = new ArrayList<>();

        // distance = 3
        Car car = new Car("winner");
        car.move(5);
        car.move(5);
        car.move(5);
        cars.add(car);

        // distance = 1
        car = new Car("pobi1");
        car.move(5);
        cars.add(car);

        // distance = 0
        car = new Car("pobi2");
        cars.add(car);

        List<String> winner = racing.getWinner();

        assertEquals(1, winner.size());
        assertEquals("winner", winner.get(0));
    }

    @DisplayName("자동차 거리가 2명이 같을 경우 우승자 2명 확인")
    @Test
    void getWinner_우승자_2명() {
        List<Car> cars = new ArrayList<>();

        // distance = 1
        Car car = new Car("pobi");
        car.move(5);
        cars.add(car);

        // distance = 2
        car = new Car("winner1");
        car.move(5);
        car.move(5);
        cars.add(car);

        // distance = 2
        car = new Car("winner2");
        car.move(5);
        car.move(5);
        cars.add(car);

        List<String> winners = racing.getWinner(cars);

        assertEquals(2, winners.size());
        assertThat(winners).containsExactlyInAnyOrder("winner1", "winner2");
    }

    @DisplayName("startRace 메소드 랜덤값 4일 때 테스트 진행")
    @Test
    void startRaceTest_랜덤값_4_일_경우() {
        Racing racing = new Racing(createRandom(4));
        racing.initRace("pobi1,pobi2,pobi3");

        racing.startRace();

        assertThat(racing.getWinner()).containsExactlyInAnyOrder("pobi1", "pobi2", "pobi3"); // 우승자 동일
        assertEquals(1, racing.getCars().get(0).getDistance()); // 이동거리 0
        assertEquals(1, racing.getCars().get(1).getDistance());
        assertEquals(1, racing.getCars().get(2).getDistance());
    }

    @DisplayName("startRace 메소드 랜덤값 1일 때 테스트 진행")
    @Test
    void startRaceTest_랜덤값_1_일_경우() {
        Racing racing = new Racing(createRandom(1));
        racing.initRace("pobi1,pobi2,pobi3");

        racing.startRace();

        assertThat(racing.getWinner()).containsExactlyInAnyOrder("pobi1", "pobi2", "pobi3"); // 우승자 동일
        assertEquals(0, racing.getCars().get(0).getDistance()); // 이동거리 0
        assertEquals(0, racing.getCars().get(1).getDistance());
        assertEquals(0, racing.getCars().get(2).getDistance());
    }

    // 랜덤값을 동일하게
    private Random createRandom(int returnValue) {
        return new Random() {
            public int nextInt(int bound) {
                return returnValue;
            };
        };
    }

}
