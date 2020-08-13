package pobiRacingCar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarNameTest {
    @Test
    void doCreateCarName() {
        CarName name = new CarName("pobi");
        // assertThat(carName.getName()).isEqualTo("pobi"); getter사용 ㄴㄴ 객체로 비교
        assertThat(name).isEqualTo(new CarName("pobi"));
    }
}
