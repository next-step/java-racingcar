package racingcar.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CarInformationTest {
    @Test
    void CarInformation은_자동차_정보를_갖는_VO다() {
        String name = "yong";
        Position position = Position.valueOf(10);
        CarInformation carInformation = new CarInformation(name, position);

        assertThat(carInformation).isInstanceOf(CarInformation.class);
    }

    @Test
    void CarInformation객체는_이름만으로_생성할_수_있다() {
        String name = "yong";
        CarInformation carInformation = new CarInformation(name);

        assertThat(carInformation).isInstanceOf(CarInformation.class);
    }

    @Test
    void CarInformation객체에서_이름을_추출할_수_있다() {
        String name = "yong";
        CarInformation carInformation = new CarInformation(name);

        assertThat(carInformation.getName()).isEqualTo(name);
    }

    @Test
    void CarInformation객체에서_위치를_추출할_수_있다() {
        String name = "yong";
        Position position = Position.valueOf(10);
        CarInformation carInformation = new CarInformation(name, position);

        assertThat(carInformation.getPosition()).isEqualTo(position);
    }
}