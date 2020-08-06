package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CarsTest {

    @DisplayName("최소한의 차량 입력 유효성 테스트")
    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    public void 레이싱_참가_차량은_1대_이상이다(int carCount) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Cars(carCount));
    }

    @DisplayName("입력한 값 만큼 자동차 생성 여부 테스트")
    @ParameterizedTest
    @ValueSource(ints = {3, 4, 5})
    public void 자동차_그룹_생성(int carCount) {
        int verificationValue = carCount;
        Cars cars = new Cars(carCount);
        assertThat(cars.getCars().size()).isEqualTo(verificationValue);
    }

}