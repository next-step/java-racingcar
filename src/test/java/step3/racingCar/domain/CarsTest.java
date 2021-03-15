package step3.racingCar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class CarsTest {

    @InjectMocks
    private Cars cars;
    @Spy
    private List<Car> carList = new ArrayList<>();
    @Mock
    private Car car;

    @InjectMocks
    private Cars statCars;
    @Spy
    private List<Car> statCarList = new ArrayList<>();

    private String name = "name";

    private static final int CAR_NUM = 4;
    private static final int INIT_NUM = 0;

    @BeforeEach
    void setUp() throws NoSuchFieldException, IllegalAccessException {
        MockitoAnnotations.initMocks(this);
        for (int i = 0; i < CAR_NUM; i++) {
            carList.add(car);
        }
        cars = new Cars(carList);

        for (int i = 0; i < CAR_NUM; i++) {
            statCarList.add(createMockCar(i));
        }
        statCars = new Cars(statCarList);
    }


    @Test
    void createAndSetCars() {

        /*
         * Cars 내부의 List<Car>을 확인하는 로직
         * extracting은 List에 담아서 반환하기 때문에 2차원 리스트의 크기로 확인해야한다.
         * */

        assertThat(cars).extracting("cars")
                .hasOnlyElementsOfType((new ArrayList<Car>()).getClass())
                .hasSameSizeAs(new List[]{carList});

    }


    @ParameterizedTest
    @CsvSource("0, 1, 2")
    @DisplayName("자동차 집합이 보유중인 자동차들의 전진 횟수 리스트를 반환하는지 테스트한다.")
    void checkForwardTest(int input) {
        when(car.getForwardNum()).thenReturn(input);
        List<Integer> forwardNums = cars.checkForward();

        verify(car, times(CAR_NUM)).getForwardNum();
        assertThat(forwardNums.size()).isEqualTo(CAR_NUM);
        assertThat(forwardNums).containsOnly(input);
    }

    @Test
    @DisplayName("자동차 집합이 전진할지 여부를 확인했는지 리스트들의 메소드 호출 횟수를 확인한다.")
    void tryForwardTest() {
        cars.tryForward();
        verify(car, times(CAR_NUM)).goForward();
    }

    @Test
    @DisplayName("자동차 집합이 자동차의 이름과 전진 횟수를 담은 Map을 반환하는지 테스트한다.")
    void checkCarStatusTest() {
        Map<String, Integer> carStatus = statCars.checkCarStatus();
        assertThat(carStatus.size()).isEqualTo(CAR_NUM);
        for (int i = 0; i < CAR_NUM; i++) {
            assertThat(carStatus.get(name + i)).isEqualTo(i);
        }
    }


    /*
     * index를 넘겨받아 name+i의 이름과 i만큼의 forwardNum을 지니는 Mock Car를 생성하고 반환한다.
     * */
    private Car createMockCar(int index) throws NoSuchFieldException, IllegalAccessException {

        Car testCar = mock(Car.class);
        Field nameField = testCar.getClass().getDeclaredField("name");
        nameField.setAccessible(true);
        nameField.set(testCar, name + index);
        when(testCar.getName()).thenReturn(name + index);

        Field forwardField = testCar.getClass().getDeclaredField("forwardNum");
        forwardField.setAccessible(true);
        forwardField.set(testCar, index);
        when(testCar.getForwardNum()).thenReturn(index);

        return testCar;
    }

}
