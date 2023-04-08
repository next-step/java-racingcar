package view;

import domain.Car;
import domain.Move;
import java.util.List;

public class ResultView {

    private final static String BLANK = "";


    public static void createResultView(List<Car> carList) {
        carList.stream()
                .map(Car::getMove)
                .forEach(ResultView::drawDistance);
        System.out.println(BLANK);
    }

    private static void drawDistance(Move move) {
        System.out.println(move.getCarCurrentDistance());
    }
}
