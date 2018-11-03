package racing.domain;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {
    TestNumberProvider testNumberProvider = new TestNumberProvider();

    @Before
    public void setup() {
        RacingCar.RANDOM_PROVIDER = testNumberProvider;
    }

    @Test
    public void 난수값에_따른_전진확인() {
        // 레이싱카를 초기화한 다음
        RacingCar car = new RacingCar();

        // 포지션이 0이 맞는지 확인
        assertThat(car.getPosition()).isEqualTo(0);

        // 4이하 값 설정 후 포지션 확인하기
        testNumberProvider.setTestNumber(3);
        car.rush();

        assertThat(car.getPosition()).isEqualTo(0);

        // 4이상 값 설정 후 포지션 확인하기
        testNumberProvider.setTestNumber(4);
        car.rush();

        assertThat(car.getPosition()).isEqualTo(1);

        car.rush();
        assertThat(car.getPosition()).isEqualTo(2);
    }
}