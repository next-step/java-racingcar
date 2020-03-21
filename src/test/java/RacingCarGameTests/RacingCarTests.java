package RacingCarGameTests;

import domain.RacingCar;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import service.impl.RandomMoveRule;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;

@DisplayName("레이싱 카 테스트")
public class RacingCarTests {

    @Mock
    private Random random;

    @DisplayName("차 생성 테스트")
    @Test
    public void generateCarTest() {
        assertThatCode(() -> RacingCar.newInstance(new RandomMoveRule()))
                .doesNotThrowAnyException();
    }

    @DisplayName("차 이동 테스트")
    @ParameterizedTest(name = "랜덤 값 : {0} -> 결과 : {1}")
    @CsvSource({"0,0", "1,0", "2,0", "3,0", "4,1", "5,1", "6,1", "7,1", "8,1", "9,1"})
    @ExtendWith(MockitoExtension.class)
    public void moveCarTest(int randomValue, int expectedPosition) {
        given(random.nextInt(anyInt())).willReturn(randomValue);
        RacingCar racingCar = RacingCar.newInstance(new RandomMoveRule(random));
        racingCar.move();
        assertThat(racingCar.getPosition()).isEqualTo(expectedPosition);
    }

}
