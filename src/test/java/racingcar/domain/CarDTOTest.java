package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CarDTOTest {

    @Test
    public void createCarDTP() {
        CarDTO carDTO = new CarDTO("bus", 5);
        assertThat(carDTO.getName()).isEqualTo("bus");
    }

    @Test
    public void getPlace() {
        CarDTO carDTO = new CarDTO("bus", 5);
        assertThat(carDTO.getPosition()).isEqualTo("-----");

    }

}