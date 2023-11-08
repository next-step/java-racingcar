package champion;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CarServiceTest {
    private List<Car> generateCars = new ArrayList<Car>();

    @BeforeEach
    void setCars() {
        generateCars.add(new Car("pobi"));
        generateCars.add(new Car("crong"));
        generateCars.add(new Car("honux"));
    }

    @DisplayName("N대 자동차 생성")
    @Test
    void n대자동차_생성_테스트() {
        String[] names = {"pobi", "crong", "honux"};
        assertEquals(CarService.generate(names).size(), generateCars.size());
    }

    @DisplayName("자동차 이름 길이")
    @Test
    void 자동차_이름_길이체크() {
        assertThrows(IllegalArgumentException.class, () -> {
            CarService.generate(new String[]{"invalidName"});
        });

        assertThrows(IllegalArgumentException.class, () -> {
            CarService.generate(new String[]{""});
        });
    }


}
