import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RacingGameTest {
    // 자동차 경주의 최초 설정 세팅 함수에 대한 Junit 테스트 구현
    @ParameterizedTest
    @ValueSource(ints = {2, 0, 5, 1})
    public void gameInitialSet(int number) {

        if (number <= 1) {
            throw new IllegalArgumentException("입력값이 잘못되었습니다. 레이싱 게임을 위해서 최소한 1보다 큰 숫자로 다시 입력해주세요.");
        }
    }
}

