package racing.game;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racing.domain.car.Car;
import racing.domain.car.Cars;
import racing.domain.game.Calculator;
import racing.fake.FakeRandomCalculator;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class RacingGameTest {

    /*@Test
    void 주어진_횟수만큼_자동차에_랜덤값_넣기() {
        //given
        int count = 4;
        int carCount = 3;

        try(MockedStatic<RacingGame> staticRacingGame = mockStatic(RacingGame.class)) {
            RacingGame.countCarGoAndStop(count, carCount);
            //잘 호출되었는지 확인
            staticRacingGame.verify(() -> RacingGame.countCarGoAndStop(count, carCount), times(1));
        }
    }*/

    @ParameterizedTest
    @ValueSource(ints = 5)
    void 주어진_5번_횟수만큼_전진하는_메서드_실행(int count) {
        List<Car> items = new ArrayList<>();
        Car car1 = new Car( "bmw", 0);
        Car car2 = new Car( "volvo",0);
        items.add(car1);
        items.add(car2);
        Cars cars = new Cars(items);
        Calculator racingCalculator = new FakeRandomCalculator();

        while (count > 0) { // 5번 실행되면 5번 전진하기 때문에 검증
            count--;
            cars.carGoAndStop(racingCalculator);
        }

        assertThat(items).allMatch(car -> car.getPosition() == 5);
    }

}
