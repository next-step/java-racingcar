package racing;

import org.junit.BeforeClass;
import org.junit.Test;
import racing.view.InputView;


import static org.assertj.core.api.Assertions.assertThat;


/***
 * Test가 안됨. Scanner는 테스트가 따로 안될까..?
 */
public class InputViewTest {

    static InputView iv;

    @BeforeClass
    public static void beforeAll() {
        iv = new InputView();
    }

    @Test
    public void 자동차수() {

        int numOfCars = iv.numOfCars();

        assertThat(numOfCars).isEqualTo(3);

    }


    @Test
    public void 경기수() {
        int times = iv.times();

        assertThat(times).isEqualTo(5);
    }
}