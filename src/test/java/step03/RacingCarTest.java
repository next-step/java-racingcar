package step03;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;


public class RacingCarTest {

    @Mock
    private MoveStrategy moveStrategy;
    private RacingCar racingCar;

    @BeforeEach
    void setRacingCar() {
        MockitoAnnotations.initMocks(this);
        racingCar = new RacingCar(moveStrategy);
    }

    @ParameterizedTest
    @DisplayName("무조건 전진하는 차로 tryToMove가 제대로 동작하는지 테스트")
    @ValueSource(ints = {1, 2, 3})
    void moveTest(int tryCount) {
        //given
        given(moveStrategy.move()).willReturn(true);

        //when
        for (int i = 0; i < tryCount; i++) {
            racingCar.tryToMove();
        }

        //then
        assertThat(racingCar.getMovingRange()).isEqualTo(tryCount);

    }
}
