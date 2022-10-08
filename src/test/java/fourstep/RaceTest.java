package fourstep;

import fourstep.logic.Car;
import fourstep.logic.Race;
import fourstep.logic.RandomNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.*;

public class RaceTest {

    private ArrayList<Car> cars = new ArrayList<>();

    @Test
    @BeforeEach
    public void setUp() {
        Car busung = new Car("busung", 3);
        Car isak = new Car("isak", 2);
        Car pobi = new Car("pobi", 4);

        cars.add(busung);
        cars.add(isak);
        cars.add(pobi);
    }

    @Test
    @DisplayName("가장 멀리 이동한 차의 거리 구하기")
    public void getMaxLocationTest() {
        Race race = new Race(cars);
        int maxLocation = race.getMaxLocation();
        assertThat(maxLocation).isEqualTo(4);
    }

    @Test
    @DisplayName("최종 우승자 구하기")
    public void makeWinnerTest() {
        Race race = new Race(cars);
        ArrayList<String> winners = race.getWinners();
        assertThat(winners).contains("pobi");
    }
}
