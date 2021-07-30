package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarRacingTest {

    @Test
    @DisplayName("입력한 자동차 수만큼 객체가 생성됐는지 확인한다.")
    void input_car_count() {
        //given
        int carCount = 3;

        //when
        CarRacing carRacing = new CarRacing(carCount);

        //then
        assertThat(carRacing.racing().size()).isEqualTo(carCount);
    }
}