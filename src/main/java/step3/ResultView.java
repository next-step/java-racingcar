package step3;

import java.util.List;

public class ResultView {

    private final String PRINT_EXPRESSION_STR = "-";

    public ResultView() {
        System.out.println("실행 결과");
    }

    public void printOutResult(List<Car> carList) {
        for (Car car : carList) {
            System.out.println(StringUtil.repeat(PRINT_EXPRESSION_STR, car.getCurrentPosition()));
        }
        System.out.println();
    }
}
