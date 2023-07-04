package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CarsTest {

    @Test
    @DisplayName("한 턴에 대해 자동차들에게 게임 실행 메시지을 했는지 확인한다.")
    public void 한_턴에_대해_자동차들에게_게임_실행_메시지_전달한다() throws Exception {
        Car chanCar = mock(Car.class);
        Car iptCar = mock(Car.class);
        Cars cars = new Cars(List.of(chanCar, iptCar));

        cars.takeTurn();

        verify(chanCar).progress();
        verify(iptCar).progress();
    }

}
