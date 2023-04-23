package carracing.view;

import carracing.Car;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 1. 이름이 포비이고, 포지션이 1인 자동차를 입력받을 떄 "pobi : -"를 반환한다.
 */
class ResultViewTest {
    ResultView resultView;
    
    @BeforeEach
    void init() {
        resultView = new ResultView();
    }
    
    @Test
    void print() {
        Car car = new Car("pobi");
        car.move(4);
        Assertions.assertEquals(resultView.print(car), "pobi : -");
    }

}