package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class ParticipateCarsTest {

    @DisplayName("게임에 참여하는 자동차들에게 이동을 지시하고 List 타입의 결과를 반환한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4})
    void tryMove(int numberOfCar) {
        ParticipateCars participateCars = new ParticipateCars(numberOfCar);
        List<Integer> actualResult = participateCars.tryMove(new Random());

        assertThat(actualResult.size()).isEqualTo(numberOfCar);

    }
}
