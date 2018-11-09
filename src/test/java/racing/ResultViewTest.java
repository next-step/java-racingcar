package racing;

import org.junit.BeforeClass;
import org.junit.Test;
import racing.dto.Car;
import racing.view.ResultView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultViewTest {

    static ResultView rv;
    static List<Car> cars;

    @BeforeClass
    public static void beforeMethod(){
        rv = new ResultView();
        cars = Arrays.asList(new Car(3,"test1"),new Car(5,"test2"),new Car(8,"test3"));
    }


    /*@Test
    public void 대쉬카운트() {

        String dashs = rv.getDashs(4);

        assertThat(dashs).isEqualTo("----");
    }*/

    @Test
    public void 대쉬출력2() {
        StringBuilder sb = new StringBuilder();
        for(int i =0 ; i< 4; i++){
            sb.append("-");
        }
        assertThat(sb.toString()).isEqualTo("----");
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

    @Test
    public void 우승자리스트() {
        rv.getWinnersList(cars);
    }
}