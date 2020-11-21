package racingcar;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ResultViewTest {

    String[] carNames = {"john", "tom", "myung"};
    Car car = new Car();

    @BeforeAll
    static void beforeAll() {
        Car car = new Car();
    }

    @DisplayName("기본출력")
    @Test
    void print() {
        CarRace carRace = new CarRace(carNames, 5);
        carRace.race();
        ResultView.print(carRace);
    }


}
