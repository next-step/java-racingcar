package step4.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {

    @Test
    @DisplayName("자동차의 이름 개수만큼 자동차를 생성한다.")
    void makeCars() {
        String[] nameArr = {"귤", "자몽", "오렌지"};
        Cars cars = new Cars(nameArr);

        Assertions.assertThat(cars.carCount()).isEqualTo(3);
    }
}
