package game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultViewTest {

    @Test
    @DisplayName("자동차 경기 결과를 출력합니다.")
    void test1() {
        Cars cars = Cars.generate(3);
        cars.drive();
        cars.drive();
        cars.drive();
        cars.drive();
        ResultView resultView = new ResultView(cars);
        resultView.show();
    }
}
