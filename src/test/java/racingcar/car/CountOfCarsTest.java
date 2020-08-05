package racingcar.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CountOfCarsTest {
    @DisplayName("자동차 생성 수량 객체 생성")
    @Test
    void newInstance() {
        //when
        CountOfCars countOfCars = CountOfCars.newInstance(1);

        //then
        assertThat(countOfCars).isNotNull();
    }


    @DisplayName("잘못된 생성 수량을 입력하면 에러를 발생시킨다.")
    @Test
    void newInstanceWithWrongCount() {
        assertThatIllegalArgumentException().isThrownBy(() -> CountOfCars.newInstance(0))
                .withMessageContaining("최소 1대 이상의 자동차를 생성해야합니다.");
    }
}
