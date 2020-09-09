package step3.utils;

import step3.domain.Car;
import step3.operation.Operation;
import step3.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class FindWinners {
    public static void findWinners(List<Car> cars, int count) {
        List<String> winners = new ArrayList<>();
        for(int i = 0; i < cars.size(); i++) {
            if(cars.get(i).getPosition() == count) {
                winners.add(cars.get(i).getName());
            }
        }
        ResultView.result(winners);
    }
}
