package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

class CarRacingTest {

    @Test
    @DisplayName("입력한 자동차 수만큼 객체가 생성됐는지, 입력한 순서대로 저장되었는지 확인한다.")
    void input_car_count() {
        //given
        String carNameList = "test1,test2,test3";
        int expected = 3;
        String[] carNameArray = carNameList.split(",");

        //when
        CarRacing carRacing = new CarRacing(carNameList);

        //then
        assertThat(carRacing.racing().size()).isEqualTo(expected);
        assertThat(carRacing.racing().get(0).getCarName()).isEqualTo(carNameArray[0]);
        assertThat(carRacing.racing().get(1).getCarName()).isEqualTo(carNameArray[1]);
        assertThat(carRacing.racing().get(2).getCarName()).isEqualTo(carNameArray[2]);
    }

    @ParameterizedTest
    @CsvSource({"a,b,c", "test1,test2,test3"})
    @DisplayName("racing()을 테스트한다.")
    void doRacingStart(String carCount) {
        assertThatCode(() -> {
            CarRacing carRacing = new CarRacing(carCount);
            carRacing.racing();
        }).doesNotThrowAnyException();
    }
}