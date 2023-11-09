package car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarServiceTest {

    private List<Car> generateCars = new ArrayList<Car>();
    private List<Car> oneWinners = new ArrayList<Car>();
    private List<Car> twoWinners = new ArrayList<Car>();

    @BeforeEach
    void setCars() {
        generateCars.add(new Car("pobi"));
        generateCars.add(new Car("crong"));
        generateCars.add(new Car("honux"));

        oneWinners.add(new Car("pobi", 4));
        oneWinners.add(new Car("crong", 6));
        oneWinners.add(new Car("honux", 8));

        twoWinners.add(new Car("pobi", 4));
        twoWinners.add(new Car("crong", 6));
        twoWinners.add(new Car("honux", 6));
    }

    @DisplayName("N대 자동차 생성")
    @Test
    void n대자동차_생성_테스트() {
        String[] names = {"pobi", "crong", "honux"};
        assertEquals(CarService.generate(names).size(), generateCars.size());
    }

    @DisplayName("우승자 리스트")
    @Test
    void N명_우승자_테스트() {
        assertThat(CarService.winnersList(oneWinners)).hasSize(1);
        assertThat(CarService.winnersList(twoWinners)).hasSize(2);
    }

}
