package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

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
        assertThat(carRacing.getCars().size()).isEqualTo(expected);
        assertThat(carRacing.getCars().get(0).getCarName()).isEqualTo(carNameArray[0]);
        assertThat(carRacing.getCars().get(1).getCarName()).isEqualTo(carNameArray[1]);
        assertThat(carRacing.getCars().get(2).getCarName()).isEqualTo(carNameArray[2]);
    }

    @ParameterizedTest
    @ValueSource(strings = {"test,abc,macbook", "abcde,nextstep"})
    @DisplayName("자동차 이름이 5글자를 초과하는 경우 IllegalArgumentException가 발생한다.")
    void check_validate_carname_test(String carNameString) {
        assertThatThrownBy(() -> {
            new CarRacing(carNameString);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 다섯 글자를 초과할 수 없습니다");

    }

    @ParameterizedTest
    @CsvSource(value = {"a,b:2", "test1,test2,test3:3"}, delimiter = ':')
    @DisplayName("racing 및 전진했을 때, 값이 증가하는지 테스트한다.")
    void doRacingStart(String carNameString, int expectedCount) {
        assertThatCode(() -> {
            CarRacing carRacing = new CarRacing(carNameString);

            List<Car> racing = carRacing.getCars();
            int expected = 1;

            racing.get(0).moveForward(4);

            assertThat(racing.size()).isEqualTo(expectedCount);
            assertThat(racing.get(0).getMoveDistance()).isEqualTo(expected);
        }).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("우승자를 확인한다.")
    void extract_winner_test() {
        String carNameList = "test1,test2,test3";
        CarRacing carRacing = new CarRacing(carNameList);
        String expected = "test1,test2";

        List<Car> racing = carRacing.getCars();
        racing.get(0).moveForward(4);
        racing.get(1).moveForward(4);

        String result = carRacing.extractWinner(racing);
        assertThat(result).isEqualTo(expected);
    }
}