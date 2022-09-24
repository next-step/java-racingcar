import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

public class RacingGameTest {

    private int carCount;
    private int tryCount;
    private int randomValue;

    @BeforeEach
    void setUp() {
        carCount = 3;
        tryCount = 5;
        randomValue = 4;
    }

    /**
     * 실제 게임 로직 테스트 (익셉션 발생하지 않으면 성공으로 간주)
     */
    @Test
    public void racingGame_playRacingGame() {
        assertThatNoException().isThrownBy(() -> {
            RacingGame.playRacingGame(carCount, tryCount);
        });
    }

    /**
     * 자동차 개수, 시도 횟수 전달 시 실행결과가 출력되는지 확인 (익셉션 발생하지 않으면 성공으로 간주)
     */
    @Test
    public void racingGame_moveCarsByTryCount() {
        assertThatNoException().isThrownBy(() -> {
            RacingGame.moveCarsByTryCount(new int[carCount], tryCount);
        });
    }

    /**
     * 자동차 배열이 전달됐을 때 랜덤하게 움직이는지 확인
     * (익셉션 발생하지 않으면 성공으로 간주)
     * (출력된 결과 before/after 비교 -> 랜덤값이 n회 모두 4 미만이면 같을 수도 있다)
     */
    @Test
    public void racingGame_moveCars() {
        assertThatNoException().isThrownBy(() -> {
            int[] cars = new int[carCount];

            System.out.println("== before moveCars ==");
            ResultView.printCarMovements(cars);

            RacingGame.moveCars(cars);

            System.out.println("== after moveCars ==");
            ResultView.printCarMovements(cars);
        });
    }

    /**
     * 자동차 배열과 index가 전달됐을 때 index에 해당하는 자동차가 랜덤하게 움직이는지 확인
     * (익셉션 발생하지 않으면 성공으로 간주)
     * (출력된 결과 before/after 비교 -> 랜덤값이 4 미만이면 같을 수도 있다)
     */
    @Test
    public void racingGame_moveCarByRandomValue() {
        assertThatNoException().isThrownBy(() -> {
            int[] cars = new int[carCount];

            System.out.println("== before moveCars ==");
            ResultView.printCarMovements(cars);

            RacingGame.moveCarByRandomValue(cars, 0, randomValue);

            System.out.println("== after moveCars ==");
            ResultView.printCarMovements(cars);
        });
    }

    /**
     * Random 으로 추출한 숫자가 10보다 작은지 확인
     * 요구사항 : 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.
     */
    @Test
    public void racingGame_getRandomIntBound10() {
        assertThat(RacingGame.getRandomIntBound10()).isLessThan(10);
    }

}