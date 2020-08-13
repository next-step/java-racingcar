package pobiRacingCar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NameTest {
    @Test
    void doCreateCarName() {
        CarName carName = CarName("pobi");
        // assertThat(carName.getName()).isEqualTo("pobi"); getter사용 ㄴㄴ 객체로 비교
        assertThat(carName).isEqualTo(CarName("pobi"));
    }
}
