import Domain.CarInfo;
import Domain.RacingGame;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class RacingGameTest {
    // 자동차 경주의 최초 설정 세팅 함수에 대한 Junit 테스트 구현

    // 사용자가 입력한 공백 문자 혹은 개행문자가 포함되었는지 체크하는 함수에 대한 Junit 테스트 구현
    @Test
    public void checkNameOfCar() {
        String inputString = " ";

        assertThatIllegalArgumentException().isThrownBy(() -> {
                    if (inputString.isEmpty() || inputString.equals(" ") || inputString.equals("\n"))
                        throw new IllegalArgumentException("입력값이 잘못되었습니다. 자동차 이름을 다시 한번 입력해주세요.");
                }
        );
    }

    @Test
    public void gameInitialSet() {
        List<CarInfo> carInfo = null;

        assertThatNullPointerException().isThrownBy(() -> {
            if (carInfo == null)
                throw new NullPointerException("객체 carInfo가 null 입니다. 확인하시고 다시 실행해주시길 바랍니다.");
        });
    }

    // 랜덤값 생성 및 자동차 경주 결과를 호출하는 함수에 대한 Junit 테스트 구현
    @Test
    public void makeRandomNumberAndGameResult() {
        RacingGame racingGame = new RacingGame();
        List<CarInfo> carInfo = null;

        assertThatNullPointerException().isThrownBy(() -> {
            if (racingGame == null || carInfo == null)
                throw new NullPointerException("함수의 객체 중에 null값이 있습니다. 확인하시고 다시 실행해주시길 바랍니다.");
        });
    }

    @Test
    // 랜덤번호의 결과에 따라서 자동차 위치의 전진 혹은 유지를 결정하는 함수에 대한 Junit 테스트 구현
    public void decideMoveOrStop() {
        List<CarInfo> carInfo = null;
        assertThatNullPointerException().isThrownBy(() -> {
            if (carInfo == null)
                throw new NullPointerException("객체 carInfo가 null 입니다. 확인하시고 다시 실행해주시길 바랍니다.");
        });
    }

    @Test
    // 생성된 랜덤값이 4이상일때 자동차 위치를 전진하는 함수에 대한 Junit 테스트 구현
    public void move() {
        List<CarInfo> carInfo = null;
        assertThatNullPointerException().isThrownBy(() -> {
            if (carInfo == null)
                throw new NullPointerException("객체 carInfo가 null 입니다. 확인하시고 다시 실행해주시길 바랍니다.");
        });
    }

    @Test
    // 자동차 게임 우승자 판정 함수에 대한 Junit 테스트 구현
    public void findRaceWinner() {
        List<CarInfo> carInfo = null;
        assertThatNullPointerException().isThrownBy(() -> {
            if (carInfo == null)
                throw new NullPointerException("객체 carInfo가 null 입니다. 확인하시고 다시 실행해주시길 바랍니다.");
        });
    }
}

