package racingcar;

import org.junit.Test;
import racingcar.car.PowerGenerator;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    //TODO: 궁금한점이 있습니다
    //1. Test를 위해 RacingGame 클래스에 getter를 만들었는데, 이렇게 해도 되는건가요?
        // > 인스턴수 변수에 대한 getter, setter 생성 X
    //2. return type이 void인 method에 대해서는 Test를 어떻게 만들어야하는지 잘 모르겠습니다.
        // > return type이 void가 된 구조에 대해 생각해보고, 구조 개선

    //3. class에 private method가 있다면 어떻게 테스트하는게 좋을까요?


    //19.03.10 - step1 피드백, 개선한 구조에 맞게 테스트 method 수정
    @Test
    public void power값_확인() {
        PowerGenerator powerGenerator = new PowerGenerator();

        int result = powerGenerator.getPower(5);
        assertThat(result).isEqualTo(1);

        result = powerGenerator.getPower(2);
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void 전진_정지_여부_확인() {
        PowerGenerator powerGenerator = new PowerGenerator();
        int power = powerGenerator.determineMoveOrNot();
        assertThat(power).isBetween(0,1);
    }

    @Test
    public void 모든차량_1회_게임_확인() {

        RacingGame racingGame = new RacingGame(3, 1);

        racingGame.move();
        int[] carPositions = racingGame.loadResultofGame();

        assertThat(carPositions[0]).isBetween(0, 1);
        assertThat(carPositions[1]).isBetween(0, 1);
        assertThat(carPositions[2]).isBetween(0, 1);
    }

    @Test
    public void 레이싱_게임_3대_5회() {
        RacingGame racingGame = new RacingGame(3, 5);
        racingGame.move();
        int[] carPositions = racingGame.loadResultofGame();

        assertThat(carPositions[0]).isBetween(0, 4);
        assertThat(carPositions[1]).isBetween(0, 4);
        assertThat(carPositions[2]).isBetween(0, 4);
    }
}