package me.daeho.step3;

import me.daeho.step3.rule.DefaultRule;
import me.daeho.step3.rule.ForwardRule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@DisplayName("자동차 테스트")
class CarTest {
    private Car car;
    private ForwardRule forwardRule;

    @BeforeEach
    public void setup() {
        forwardRule = Mockito.mock(DefaultRule.class);
        car = Car.ready(forwardRule);
    }

    @DisplayName("전진 테스트")
    @Test
    public void forwardTest() {
        given(forwardRule.isForward()).willReturn(true);
        assertThat(car.move()).isEqualTo(1);
    }

    @DisplayName("정지 테스트")
    @Test
    public void stopTest() {
        int currentPosition = car.move();
        given(forwardRule.isForward()).willReturn(false);
        assertThat(car.move()).isEqualTo(currentPosition);
    }
}