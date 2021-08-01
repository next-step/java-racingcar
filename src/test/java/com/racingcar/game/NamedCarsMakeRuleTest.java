package com.racingcar.game;

import com.racingcar.car.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class NamedCarsMakeRuleTest {
    CarsMakeRule rule = new NamedCarsMakeRule();

    @Test
    @DisplayName("생성 룰 확인 테스트")
    public void makeCars() {
        //given
        String input = "name,test";

        //when
        List<Car> carList = rule.makeCar(input);

        //then
        assertThat(carList.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("잘못된 input 값 테스트")
    public void makeCarsWrongInput() {
        //given
        String input = "name,name232";

        //then
        assertThatIllegalArgumentException().isThrownBy(() -> {
            rule.makeCar(input);
        });
    }
}
