package racingGame.Business;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingGame.model.Car;
import racingGame.model.Rules;

class CarFactoryTest {
    
    private CarFactory carFactory;
    private Rules rules;
    private final List<Car> cars = new ArrayList<>();
    
    // 자동차 입력받은만큼 생성했는지?
    @ParameterizedTest
    @ValueSource(ints = {3, 4, 5, 6})
    void carMakeTest(int number) {
        rules = new Rules(number,1);
        carFactory = new CarFactory(rules);
        assertThat(carFactory.createCars().size()).isEqualTo(number);
    }
    
}