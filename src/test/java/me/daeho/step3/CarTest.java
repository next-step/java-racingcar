package me.daeho.step3;

import me.daeho.step3.rule.DefaultForwardRule;
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
    private DefaultForwardRule defaultForwardRule;
    private Car car;

    @BeforeEach
    public void setup() {
        defaultForwardRule = Mockito.mock(DefaultForwardRule.class);
        car = Car.ready(defaultForwardRule, DEFAULT_NAME);
    }

    @DisplayName("전진 테스트")
    @Test
    public void forwardTest() {
        given(defaultForwardRule.isForward()).willReturn(true);

        assertThat(car.move()).isEqualTo(1);
    }

    @DisplayName("정지 테스트")
    @Test
    public void stopTest() {
        DefaultForwardRule defaultForwardRule = Mockito.mock(DefaultForwardRule.class);
        given(defaultForwardRule.isForward()).willReturn(false);
        int currentPosition = car.move();
        assertThat(car.move()).isEqualTo(currentPosition);
    }

    @DisplayName("이름 확인 테스트")
    @Test
    public void getNameTest() {
        assertThat(car.getName()).isEqualTo(DEFAULT_NAME);
    }
}