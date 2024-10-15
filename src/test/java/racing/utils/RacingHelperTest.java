package racing.utils;

import com.racing.utils.RacingHelper;
import com.warmup.step3.CarRacing;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RacingHelperTest {

    @Test
    @DisplayName("모킹 데이터인 false를 반환 받는다.")
    public void isEquals_GetRandomBoolean() {
        RandomStrategyMock randomStrategy = new RandomStrategyMock();

        assertThat(randomStrategy.shouldMove()).isEqualTo(false);
    }

    @Test
    @DisplayName("0~9 사이의 랜덤 값을 반환 받는지 여부 확인합니다.")
    public void isBetween_RangeOfRandomNumber() {
        int expectedMinNum = 0;
        int expectedMaxNum = 10;

        assertThat(RacingHelper.getRandomNumber()).isGreaterThanOrEqualTo(expectedMinNum)
                .isLessThan(expectedMaxNum);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:false", "3:false", "4:true", "5:true"}, delimiter = ':')
    @DisplayName("4 이상의 숫자는 True 그 외 숫자는 False를 반환합니다.")
    public void isEquals_InputNumberAndExpectedBoolean(int number, boolean expected) {
        assertThat(CarRacing.isForward(number)).isEqualTo(expected);
    }
}
