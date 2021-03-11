package racing.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RacingCarsTest {

    RacingCars init() {
        String[] racingCarNames = "LG,SKT,KT".split(",");
        return new RacingCars(racingCarNames);
    }

    @DisplayName("이동거리가 4이상일때 자동차 이동 테스트")
    @Test
    void move() {
        //given
        RacingCars cars = init();
        List<Integer> randomValue = createRandomValue(5, 7, 8);

        //when
        RacingCars moveCars = cars.move(randomValue.iterator());
        RacingCarsDto resultDto = moveCars.createDtoList();

        //then
        assertThat(resultDto.getCarList()).allSatisfy(car -> assertThat(car.getPosition()).isEqualTo(new Position(1)));
    }

    @DisplayName("이동거리가 4미만일때 자동차 정지 테스트")
    @Test
    void stop() {
        //given
        RacingCars cars = init();
        List<Integer> randomValue = createRandomValue(2, 3, 1);

        //when
        RacingCars moveCars = cars.move(randomValue.iterator());
        RacingCarsDto resultDto = moveCars.createDtoList();

        //then
        assertThat(resultDto.getCarList()).allSatisfy(car -> assertThat(car.getPosition()).isEqualTo(new Position(0)));
    }

    @DisplayName("우승자 가리는 메서드 테스트")
    @Test
    void setWinner() {
        //given
        RacingCars cars = init();
        List<Integer> randomValue = createRandomValue(3, 5, 2);
        cars.move(randomValue.iterator());

        //when
        List<String> winner = cars.findWinners();

        //then
        assertEquals("SKT", winner.get(0));
    }

    @DisplayName("공동 우승일 경우 테스트")
    @Test
    void setCoWinner() {
        //given
        RacingCars cars = init();
        List<Integer> randomValue = createRandomValue(5, 5, 2);
        cars.move(randomValue.iterator());

        //when
        List<String> winner = cars.findWinners();

        //then
        assertEquals(2, winner.size());
        assertEquals("LG", winner.get(0));
        assertEquals("SKT", winner.get(1));
    }

    @DisplayName("데이터 전송 객체 생성 테스트")
    @Test
    void createDtoList() {
        RacingCars cars = init();
        List<Integer> randomValue = createRandomValue(5, 5, 2);
        cars.move(randomValue.iterator());

        RacingCarsDto resultDto = cars.createDtoList();

        assertThat(resultDto.getCarList()).containsExactly(new RacingCarDto("LG", new Position(1)), new RacingCarDto("SKT", new Position(1)), new RacingCarDto("KT", new Position(0)));
    }

    private List<Integer> createRandomValue(int firstCarMovePosition, int secondCarMovePosition,
                                            int thirdCarMovePosition) {
        return List.of(firstCarMovePosition, secondCarMovePosition, thirdCarMovePosition);
    }
}
