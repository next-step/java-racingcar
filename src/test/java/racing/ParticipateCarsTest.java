package racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ParticipateCarsTest {

    private ParticipateCars participateCars;

    @BeforeEach
    void setup() {
        participateCars = new ParticipateCars();
    }

    @Test
    void createCar() {
        String[] carsName = {"Morris", "Daniel", "Choi"};
        participateCars.createCar(carsName);
        List<Car> cars = participateCars.getCars();
        assertAll(
                () -> assertThat(cars.get(0).getName()).isEqualTo("Morris"),
                () -> assertThat(cars.get(1).getName()).isEqualTo("Daniel"),
                () -> assertThat(cars.get(2).getName()).isEqualTo("Choi")
        );
    }

    @Test
    void createCarNumberTest() {
        String[] carsName = {"Morris", "Daniel", "Choi"};
        participateCars.createCar(carsName);
        assertThat(participateCars.getCars().size()).isEqualTo(3);
    }

}