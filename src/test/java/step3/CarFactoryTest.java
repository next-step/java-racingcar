package step3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.CarFactory;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarFactoryTest {

    @Test
    @DisplayName("carCount의 숫자만큼 게임에 참여할 자동차가 생성되어야 한다.")
    void testCreateCars() {
        int carCount = 3;
        Assertions.assertThat(CarFactory.createCars(carCount)).hasSize(3);
    }
}