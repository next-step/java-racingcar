package carracing.view;

import carracing.domain.Car;
import java.util.List;

public class ResultView {

    public StringBuilder sb;

    public ResultView() {
        sb = new StringBuilder();
        sb.append("실행 결과\n");
    }

    public void saveResult(List<Car> cars) {
        cars.forEach(car -> {
            sb.append(car.location());
            sb.append("\n");
        });
        sb.append("\n");
    }

    public void getResult() {
        System.out.println(sb.toString());
    }
}
