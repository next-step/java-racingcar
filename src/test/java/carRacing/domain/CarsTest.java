package carRacing.domain;

import carRacing.util.GreaterThenThreeMoveStrategy;
import carRacing.util.MoveStrategy;
import carRacing.util.NumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("자동차목록 관련 테스트")
public class CarsTest {

    private static final MoveStrategy MOVE_STRATEGY = new GreaterThenThreeMoveStrategy();
    private static final NumberGenerator NUMBER_GENERATOR = new MovableNumberGenerator();
    private Cars cars;

    @BeforeEach
    void create() {
        String[] nameArray = {"AiBao", "LeBao", "FuBao"};
        cars = new Cars(nameArray, MOVE_STRATEGY);
    }

    @Test
    @DisplayName("자동차들을 모두 전진시킨다")
    void 자동차목록_전진_확인() {
        cars.move(NUMBER_GENERATOR);
        List<Car> result = cars.getCarsForPrint();

        assertThat(result).extracting("position").contains(new Position(1), new Position(1), new Position(1));

    }

    @Test
    @DisplayName("경주 우승자 목록을 리턴하는지 확인")
    void 자동차경주_우승자목록_확인() {

        cars.move(NUMBER_GENERATOR);
        List<String> nameList = cars.findWinners();

        assertThat(nameList).isEqualTo(Arrays.asList("AiBao", "LeBao", "FuBao"));
    }
}
