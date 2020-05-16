package racingcar.domain.car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.strategy.FixedMovementStrategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalStateException;
import static racingcar.domain.car.strategy.FixedMovementStrategy.MOVE;
import static racingcar.domain.car.strategy.FixedMovementStrategy.STOP;

public class ParticipateCarsTest {

    private String[] nameOfCars;
    private List<CarMoveResult> expectedResult;

    @BeforeEach
    void setUp() {
        expectedResult = new ArrayList<>();
        nameOfCars = new String[]{"pobi", "crong", "horox"};
        int[] expectedLocation = new int[]{1, 0, 1};

        for (int i = 0; i < nameOfCars.length; i++) {
            expectedResult.add(new CarMoveResult(nameOfCars[i], expectedLocation[i]));
        }
    }

    @DisplayName("게임에 참여하는 자동차들에게 이동을 지시하고 CarMoveResult의 List를 반환한다.")
    @Test
    void tryMove() {
        List<Boolean> expectedMovement = new ArrayList<>(Arrays.asList(MOVE, STOP, MOVE));
        ParticipateCars participateCars = new ParticipateCars(nameOfCars);
        List<CarMoveResult> actualResult = participateCars.moveCars(new FixedMovementStrategy(expectedMovement));

        assertThat(actualResult).usingFieldByFieldElementComparator()
                .containsAll(expectedResult);

    }

    @DisplayName("생성자의 매개값으로 들어오는 이름 배열의 크기가 0 이면 IllegalStatementException Throw")
    @Test
    void whenNamesSizeZeroThrowException() {
        String[] names = {};
        assertThatIllegalStateException()
                .isThrownBy(() -> new ParticipateCars(names))
                .withMessage("이름이 입력되지 않았습니다.");
    }
}
