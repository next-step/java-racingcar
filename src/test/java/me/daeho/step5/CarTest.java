package me.daeho.step5;

import me.daeho.step5.domain.Car;
import me.daeho.step5.domain.DefaultForwardRule;
import me.daeho.step5.domain.ForwardRule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;
import static org.mockito.BDDMockito.given;

@DisplayName("자동차 테스트")
class CarTest {
    private final static String DEFAULT_NAME = "test";
    private final DefaultForwardRule defaultForwardRule = new DefaultForwardRule();
    private Car car;

    @BeforeEach
    public void setup() {
        car = Car.ready(defaultForwardRule, DEFAULT_NAME);
    }

    @DisplayName("전진 테스트")
    @Test
    public void forwardTest() {
        car = Car.ready(new AlwaysForwardRule(), DEFAULT_NAME);
        assertThat(car.move()).isEqualTo(1);
    }

    @DisplayName("정지 테스트")
    @Test
    public void stopTest() {
        car = Car.ready(new AlwaysStopRule(), DEFAULT_NAME);
        int currentPosition = car.move();
        assertThat(car.move()).isEqualTo(currentPosition);
    }

    @DisplayName("이름 확인 테스트")
    @Test
    public void getNameTest() {
        assertThat(car.getName()).isEqualTo(DEFAULT_NAME);
    }

    private static class AlwaysForwardRule implements ForwardRule {
        @Override
        public boolean isForward() {
            return true;
        }
    }

    private static class AlwaysStopRule implements ForwardRule {
        @Override
        public boolean isForward() {
            return false;
        }
    }
}