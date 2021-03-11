package step3_racingCar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.Collections;
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
        assertThat(cars.getCars()).isInstanceOf(Collections.unmodifiableList(new LinkedList<Car>()).getClass());
        assertThat(cars.getCars().size()).isEqualTo(CARNUM);
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
