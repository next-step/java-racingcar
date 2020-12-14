package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CarsTest {
    @Test
    @DisplayName("자동차 이름 및 생성 횟수 확인")
    void createCars() {
        Cars cars = new Cars("mk,jk,num");
        List<Car> createCars = cars.getCars();
        assertThat(createCars.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("런 테스트")
    void runTest() {
        Cars cars = new Cars("fk,fkfk,mkkim");
        cars.run();
    }

    @ParameterizedTest
    @DisplayName("자동차 이름 입력 값 널 유효성 체크")
    @NullAndEmptySource
    void validNullInputNames(String names) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Cars(names);
        })
                .withMessageContaining("값이 없습니다.");
    }

    @Test
    @DisplayName("자동차 이름 구분자 체크")
    void validSeparator() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Cars("mkkim");
        })
                .withMessageContaining("자동차 이름 구분자 쉼표(,)가 없습니다.");
    }
}
