package racing.refactor.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("자동차목록 생성 테스트")
class CarsTest {

    @Test
    @DisplayName("{\"tony\", \"van\", \"poyal\"} 입력 후 각 위치가 주어졌을 때 우승자 정상 추출")
    public void winners() {
        List<Car> originalCars = Arrays.asList(
                 new Car("tony", 3)
                ,new Car("van", 2)
                ,new Car("poyal", 5)
        );
        Cars cars = new Cars(originalCars);
        List<Car> expectedWinners = Collections.singletonList(
                new Car("poyal", 5)
        );
        Cars expectedWinnerCars = new Cars(expectedWinners);

        assertEquals(expectedWinnerCars, cars.getWinners());
    }

    @Test
    @DisplayName("최고 위치 값이 5 일 때 5 리턴")
    public void topPosition() {
        List<Car> originalCars = Arrays.asList(
                 new Car("tony", 3)
                ,new Car("van", 2)
                ,new Car("poyal", 5)
        );
        Cars cars = new Cars(originalCars);
        Position expectedPosition = new Position(5);

        assertEquals(expectedPosition, cars.topPosition());
    }

    @Test
    @DisplayName("모든 자동차 전진")
    public void allMove() {
        List<Car> originalCars = Arrays.asList(
                 new Car("tony")
                ,new Car("van")
                ,new Car("poyal")
        );
        Cars cars = new Cars(originalCars);
        List<Car> expectedCars = Arrays.asList(
                new Car("tony", 1)
                ,new Car("van", 1)
                ,new Car("poyal", 1)
        );
        cars.moveCars(()->true);
        assertEquals(expectedCars, cars.toList());
    }

    @Test
    @DisplayName("모든 자동차 정지")
    public void allStop() {
        List<Car> originalCars = Arrays.asList(
                new Car("tony")
                ,new Car("van")
                ,new Car("poyal")
        );
        Cars cars = new Cars(originalCars);

        List<Car> expectedCars = Arrays.asList(
                new Car("tony", 0)
                ,new Car("van", 0)
                ,new Car("poyal", 0)
        );

        cars.moveCars(()->false);
        assertEquals(expectedCars, cars.toList());
    }
}