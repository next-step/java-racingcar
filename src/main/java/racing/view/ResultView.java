package racing.view;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import racing.core.Car;
import racing.core.ClientInput;

import java.util.List;

@Builder
public class ResultView {
    private static final String DISTANCE_MARKER = "-";
    private static final String START_TEXT = "실행 결과";

    public ResultView() {
    }

    public void printStartText(){
        System.out.println();
        System.out.println(START_TEXT);
    }

    public void printCarList(List<Car> carList){
        carList.forEach(this::printCarDistance);
        System.out.println();
    }

    private void printCarDistance(Car car){
        System.out.println(DISTANCE_MARKER.repeat(Math.max(0, car.getDistance())));
    }
}
