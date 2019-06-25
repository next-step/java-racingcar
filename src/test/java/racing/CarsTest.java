package racing;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarsTest {



    @Test
    void name() {

    }

    @Test
    void ifCarsEmptyThrowException() {
//        carList.add(new Car(new CarName("hennry"), new Position()));
//        carList.add(new Car(new CarName("helloworld"), new Position()));
//        carList.add(new Car(new CarName("java"), new Position()));

        assertThatThrownBy(() -> new Cars(new ArrayList<>())).isInstanceOf(IllegalArgumentException.class);
    }
}
