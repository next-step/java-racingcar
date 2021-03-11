package step3.racingCar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class CarsTest {

    @InjectMocks
    private Cars cars;
    @Spy
    private List<Car> carList;
    @Mock
    private Car car;

    private static final int CARNUM = 4;

    @BeforeEach
    void setUp(){
        cars = new Cars();
        carList = new LinkedList<>();
        MockitoAnnotations.initMocks(this);
        for(int i=0; i<CARNUM; i++){
            carList.add(car);
        }
    }

    @Test
    void createAndSetCars(){
        assertThat(cars).extracting("cars")
                .hasOnlyElementsOfType((new LinkedList<Car>()).getClass())
                .hasSameSizeAs(new List[]{carList});    //크기가 CARNUM이라고 바로 확인하고 싶었으나, extracting은 List에 담아서 반환하기 때문에 2차원 리스트의 크기로 확인해야함
    }


    @ParameterizedTest
    @CsvSource("0, 1, 2")
    @DisplayName("자동차 집합이 보유중인 자동차들의 전진 횟수 리스트를 반환하는지 테스트한다.")
    void checkForwardTest(int input){
        when(car.getForwardNum()).thenReturn(input);
        List<Integer> forwardNums = cars.checkForward();

        verify(car, times(CARNUM)).getForwardNum();
        assertThat(forwardNums.size()).isEqualTo(CARNUM);
        assertThat(forwardNums).containsOnly(input);
    }

    @Test
    @DisplayName("자동차 집합이 전진할지 여부를 확인했는지 리스트들의 메소드 호출 횟수를 확인한다.")
    void tryForwardTest(){
        cars.tryForward();
        verify(car, times(CARNUM)).goForward();
    }
}
