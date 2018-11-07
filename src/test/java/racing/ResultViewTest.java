package racing;

import org.junit.BeforeClass;
import org.junit.Test;
import racing.dto.Car;
import racing.view.ResultView;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultViewTest {

    static ResultView rv;
    static List<Car> cars = new ArrayList<Car>();

    @BeforeClass
    public static void beforeMethod(){
        rv = new ResultView();
        cars.add(new Car(3));
        cars.add(new Car(5));
        cars.add(new Car(8));
    }


    @Test
    public void 대쉬카운트() {

        String dashs = rv.getDashs(4);

        assertThat(dashs).isEqualTo("----");
    }

    /**
     * priint test는 어떻게 해야할까.
     * outputstream을 써야한다는데, 더 좋은 방법이 없을까.
     * 테스트 코드에 맞는 개발코드가 아닐까.
     */
    @Test
    public void 움직인차들_위치반환() {
        rv.gameResult(cars);
    }
}