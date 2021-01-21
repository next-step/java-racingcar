import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.di.CarFactory;
import racingcar.di.CarFactoryImpl;
import racingcar.domain.Car;
import racingcar.domain.MockCar;
import racingcar.utils.NameChecker;
import racingcar.utils.NameCheckerImpl;
import racingcar.utils.RankPicker;
import racingcar.utils.RankPickerImpl;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class RacingGameTest {
    NameChecker nameChecker = new NameCheckerImpl();
    CarFactory carFactory = new CarFactoryImpl();
    RankPicker rankPicker = new RankPickerImpl();
    static List<Car> mockCars = new ArrayList<>();

    @BeforeAll
    @Test
    static void injectMockCars(){
        mockCars.add(new MockCar("1th-gamjatwigim", 10));
        mockCars.add(new MockCar("3th-android", 5));
        mockCars.add(new MockCar("5th-web", 4));
        mockCars.add(new MockCar("1th-shrimpburger", 10));
        mockCars.add(new MockCar("3th-java", 5));
        mockCars.add(new MockCar("5th-kotlin", 4));
    }

    @DisplayName("자동차 이름이 없으면 안 되는 테스트")
    @Test
    void testEmptyName(){
        assertThatThrownBy(() -> {
            nameChecker.checkAvailableCarName("");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Car's name must be at least 1 letter.");
    }

    @DisplayName("자동차 이름이 6글자 이상이면 안 되는 테스트")
    @Test
    void testLongCarNameLength(){
        assertThatThrownBy(() -> {
            nameChecker.checkAvailableCarName("12356123");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Car's name must be 5 characters or less.");
    }

    @DisplayName("자동차가 잘 만들어졌는 지, 하는 테스트")
    @Test
    void testIsMakeCarList(){
        String[] inputNames = new String[]{"hello", "new", "java"};
        List<Car> cars = carFactory.makeCars(inputNames);
        assertThat(cars).extracting("name").contains("hello","new", "java");
    }

    @DisplayName("가장 빠른 자동차를 골라내는 테스트")
    @Test
    void testPickTopRankers(){
        List<Car> rankers = rankPicker.pickTopRankers(mockCars);
        assertThat(rankers).extracting("name").contains("1th-gamjatwigim","1th-shrimpburger");
    }
}
