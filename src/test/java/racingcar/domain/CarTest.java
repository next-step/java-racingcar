package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CarTest {

    //핵심로직/UI로직 테스트와 무관한 테스트 꼭 확인
    @DisplayName("Car 인스턴스화 방지 확인")
    @Test
    public void assertCarIsProtectedUtil() {
        //hasMessageContaining(Constants.PROTECTED_UTIL);
    }

    @DisplayName("Car 초기 position 0에서 시작")
    @Test
    public void assertCarInitPositionIsZero() {
        //assertEquals().(Integer.parseInt(Constants.InitPosition));
    }

    @DisplayName("Car 가능한 Strategy 모두 전진 1 or 멈춤 0")
    @Test
    public void assertCarStrategyOnlyForwardOrStop() {
        //static int 값 assertEquals, position은 이미 핵심&UI로직에서 테스트
    }

    //만에 하나 우연히 계속 같은 난수 1이 나온다면? 테스트케이스 확인 필요
    @DisplayName("RndNum 이 random이라는 것을 테스트")
    @ParameterizedTest
    @CsvSource
    public void assertRndNumIsRandom() {
        //만에 하나 우연히 계속 같은 난수 1이 나온다면? 테스트케이스 확인 필요
    }
}
