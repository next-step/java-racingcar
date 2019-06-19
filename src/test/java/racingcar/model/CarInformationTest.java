package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CarInformationTest {
    private CarName name;
    private Position position;
    private DrivingRule drivingRule;

    @BeforeEach
    void setUp() {
        this.name = CarName.valueOf("yong");
        this.position = Position.valueOf(10);
        this.drivingRule = RacingDrivingRule.createDefault();
    }

    @Test
    void CarInformation은_자동차_정보를_갖는_VO다() {
        CarInformation carInformation = CarInformation.createWithPositionAndRule(name, position, drivingRule);

        assertThat(carInformation).isInstanceOf(CarInformation.class);
    }

    @Test
    void CarInformation객체는_이름만으로_생성할_수_있다() {
        CarInformation carInformation = CarInformation.create(name);

        assertThat(carInformation).isInstanceOf(CarInformation.class);
    }

    @Test
    void CarInformation객체는_이름과_위치로_생성할_수_있다() {
        CarInformation carInformation = CarInformation.createWithPosition(name, position);

        assertThat(carInformation).isInstanceOf(CarInformation.class);
    }

    @Test
    void CarInformation객체는_이름과_룰로_생성할_수_있다() {
        CarInformation carInformation = CarInformation.createWithRule(name, drivingRule);

        assertThat(carInformation).isInstanceOf(CarInformation.class);
    }

    @Test
    void CarInformation객체에서_이름을_추출할_수_있다() {
        CarInformation carInformation = CarInformation.create(name);

        assertThat(carInformation.getName()).isEqualTo(name);
    }

    @Test
    void CarInformation객체에서_위치를_추출할_수_있다() {
        CarInformation carInformation = CarInformation.createWithPosition(name, position);

        assertThat(carInformation.getPosition()).isEqualTo(position);
    }

    @Test
    void CarInformation객체에서_룰을_추출할_수_있다() {
        CarInformation carInformation = CarInformation.createWithRule(name, drivingRule);

        assertThat(carInformation.getDrivingRule()).isEqualTo(drivingRule);
    }
}