package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.view.InputView;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @DisplayName("입력한 값 만큼 자동차 생성 여부 테스트")
    @ParameterizedTest
    @CsvSource(value = {
            "pobi,crong,honux : 3",
            "a,b,c,d,e : 5",
            "aaa,bbbb,ccccc,dd : 4"}, delimiter = ':')
    public void 자동차_그룹_생성(String carNames, int result) {
        int verificationValue = result;
        InputView inputView = new InputView();
        Cars cars = new Cars(inputView.names(carNames));
        assertThat(cars.stream().count()).isEqualTo(verificationValue);
    }
}