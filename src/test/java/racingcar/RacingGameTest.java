package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RacingGameTest {

    private Car[] cars;

    @BeforeEach
    void setUp() {
        // TODO : 테스트코드를 작성하기 위해 private메소드를 public으로 바꾸게 돼요, 괜찮은걸까요?
        cars = RacingGame.createCars(4);
    }

    @Test
    public void 입력숫자만큼_Car_생성() {
        assertThat(cars).hasSize(4);
    }

    @Test
    public void 라운드_1회_진행() {
        // TODO : 랜덤 숫자가 메소드 내에 있으니 테스트를 어떻게 해야할지 모르겠어요
        Arrays.stream(cars).forEach(car -> assertThat(car.getPosition()).isGreaterThanOrEqualTo(0));
    }

    @Test
    public void 전체_게임_진행() {
        // TODO : 테스트 작성을 고민 하다보니 왠지 playGame 메소드 자체가 불필요하게 느껴지는 것 같아요..
        // 메인 클래스처럼 생각하고 짜버린 코드 같은데.. 불필요할까요?ㅠㅠ
        // 테스트 픽스처를 사용할 수 없어서 더 의구심이 듭니다..
        RacingGame.playGame(4, 5);
    }

}
