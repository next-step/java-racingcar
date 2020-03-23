package carRacing;

import carRacing.view.ResultView;
import org.assertj.core.util.VisibleForTesting;

import java.util.ArrayList;
import java.util.List;

public class RacingObserver {

    ResultView resultView;
    List<Integer> carPositions;

    public RacingObserver(List<Car> cars) {
        resultView = new ResultView();
        carPositions = observe(cars);
    }

    public void tracking(List<Car> car) {
        carPositions = observe(car);
        resultView.showGameState(carPositions);
    }

    public List<Integer> observe(List<Car> cars) {
        ArrayList<Integer> positions = new ArrayList<>();

        int i = positions.size();
        for(Car car : cars) {
            positions.add(i++, car.inquiryPosition());
        }
        return positions;
    }
}
