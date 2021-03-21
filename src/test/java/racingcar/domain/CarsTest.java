package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.service.MoveStrategy;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    private Cars cars;
    MoveStrategy stubMoveStrategy = new StubMoveStrategy();

    @BeforeEach
    void beforeTest() {
        Name[] names = {new Name("abc"), new Name("def"), new Name("ghi")};
        int[] currentLocation = {1, 2, 3};
        cars = new Cars(currentLocation, names);
    }

    @Test
    @DisplayName("자동차들을 움직이게 시켰을 때 움직임 전략에 따른 테스트")
    void move() {
        // given
        Cars testCars = new Cars(cars);
        int[] expectLocation = {2, 3, 4};

        // when
        testCars.move(stubMoveStrategy);

        // then
        for (int i = 0; i < 3; i++) {
            assertThat(testCars.getCars().get(i).getCurrentLocation()).isEqualTo(expectLocation[i]);
        }
    }

    @Test
    @DisplayName("승자 체크 테스트")
    void winners() {
        // given
        Cars testCars = new Cars(cars);
        String[] expectWinners = {"ghi"};

        // when
        List<Car> resultWinners = testCars.winners();
        List<String> winners = new ArrayList<>();
        for (Car car : resultWinners) {
            winners.add(car.getName());
        }

        // then
        assertThat(winners).containsExactly(expectWinners);
    }

    public class StubMoveStrategy implements MoveStrategy {
        @Override
        public Boolean getIsMove() {
            return true;
        }
    }
}
