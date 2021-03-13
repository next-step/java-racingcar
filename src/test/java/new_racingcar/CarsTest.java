package new_racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Cars 테스트")
class CarsTest {

    @ParameterizedTest
    @ValueSource(ints = {3, 4, 5})
    @DisplayName("자동차 생성 개수 확인")
    public void createCarsSizeTest(int playerCount) throws Exception {
        //given
        Cars car = new Cars(playerCount);

        //when
        int carSize = car.getUnmodifiableCars().size();

        //then
        assertThat(carSize).isEqualTo(playerCount);
    }
}