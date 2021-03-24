package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.service.MoveStrategy;

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
        Name[] names = {new Name("abc"), new Name("def"), new Name("ghi")};
        int[] expectLocation = {2, 3, 4};
        Cars expectCars = new Cars(expectLocation, names);

        // when
        testCars.move(stubMoveStrategy);

        // then
        assertThat(testCars).isEqualTo(expectCars);
    }


    @Test
    @DisplayName("승자 체크 테스트2")
    void winners() {
        // given
        Cars testCars = new Cars(cars);
        Cars expectCars = new Cars(new int[]{3}, new Name[]{new Name("ghi")});

        // when
        Cars resultWinners = testCars.winners();

        // then
        assertThat(resultWinners).isEqualTo(expectCars);
    }


    public class StubMoveStrategy implements MoveStrategy {
        @Override
        public Boolean getIsMove() {
            return true;
        }
    }
}
