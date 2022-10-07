package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.condition.MoveCondition;
import racingcar.condition.RandomMoveCondition;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {
    private MoveCondition moveCondition;

    @BeforeEach
    public void setUp() {
        this.moveCondition = new RandomMoveCondition();
    }

    @DisplayName("Cars 클래스의 makeCars 메서드는 입력되는 차의 대수만큼 생성한다.")
    @ParameterizedTest
    @ValueSource(strings = {"유민,지연,민수"})
    void makeCars(String name) {
        List<String> names = Arrays.asList(name.split(","));
        Cars car = new Cars(names, moveCondition);
        int carNum = car.getCars().size();
        assertThat(carNum).isEqualTo(name.split(",").length);
    }
}