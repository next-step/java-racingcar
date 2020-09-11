package step4.utils;

import step4.domain.Car;
import step4.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class FindWinners {
    public static void findWinners(List<Car> cars, int count) {
        List<String> winners = new ArrayList<>();
        for(int i = 0; i < cars.size(); i++) {
            winners = makeWinnersList(cars, i);
        }
        ResultView.result(winners);
    }

    public static List<String> makeWinnersList(List<Car> cars, int index) {
        List<String> winners = new ArrayList<>();

        int maxPosition = Position.maxPosition(cars.get(index));
        if(cars.get(index).getPosition() == maxPosition) {
            winners.add(cars.get(index).getName());
        }
        return winners;
    }
}
