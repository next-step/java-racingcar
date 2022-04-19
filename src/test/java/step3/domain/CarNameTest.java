package step3.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CarNameTest {

    @Test
    void createTest() {
        CarName carName = new CarName("car1");

        assertThat(carName.equals(new CarName("car1"))).isTrue();
    }

}