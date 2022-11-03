package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.domain.CarName;
import racing.view.InputView;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarNameTest {
    private final InputView inputView = new InputView();

    @Test
    @DisplayName("자동차 이름이 5자이내인 경우 정상적으로 세팅되는지 확인")
    void getCarName() {

        assertEquals(new CarName("pobis").getCarName(), "pobis");
    }
}