package racing.domain;

import org.junit.Before;
import org.junit.Test;
import racing.testutil.TestNumberProvider;

import static org.assertj.core.api.Assertions.assertThat;
import static racing.domain.RacingCar.MOVE_BOUND_VALUE;

public class RacingCarTest {
    TestNumberProvider testNumberProvider = new TestNumberProvider();

    @Before
    public void setup() {
        RacingCar.RANDOM_PROVIDER = testNumberProvider;
    }


    @Test
    public void 레이싱카에는_이름이_들어간다() {
        RacingCar car = new RacingCar("test");
        assertThat(car.getName()).isEqualTo("test");
    }

    @Test
    public void 경계값_미만인_경우_정지() {
        RacingCar car = new RacingCar("test");

        // 초깃값은 0이다.
        assertThat(car.getPosition()).isEqualTo(0);

        // 4이하인경우 정지상태 유지
        testNumberProvider.setTestNumber(MOVE_BOUND_VALUE - 1);
        assertThat(car.rush()).isEqualTo(0);
    }

    @Test
    public void 경계값_이상인_경우_전진() {
        RacingCar car = new RacingCar("test");

        // 초깃값은 0이다.
        assertThat(car.getPosition()).isEqualTo(0);

        // 4이하인경우 정지한다.
        testNumberProvider.setTestNumber(MOVE_BOUND_VALUE);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    public void 여러번_시도시_정상동작여부_확인() {
        // 레이싱카를 초기화한 다음
        RacingCar car = new RacingCar("test");

        // 포지션이 0이 맞는지 확인
        assertThat(car.getPosition()).isEqualTo(0);

        // 4이하 값 설정 후 포지션 확인하기
        testNumberProvider.setTestNumber(3);
        assertThat(car.rush()).isEqualTo(0);

        // 4이상 값 설정 후 포지션 확인하기
        testNumberProvider.setTestNumber(4);
        assertThat(car.rush()).isEqualTo(1);
        assertThat(car.rush()).isEqualTo(2);
    }
}