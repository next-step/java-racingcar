package step3;

import java.util.List;

public class ResultView {

    public ResultView() {
        System.out.println("실행 결과");
    }
    
    public void printOutResult(List<Car> carList) {
        for (Car car : carList) {
            System.out.println(StringUtil.printToHyphen(car.getCurrentPosition()));
        }
        System.out.println("");
    }
}
