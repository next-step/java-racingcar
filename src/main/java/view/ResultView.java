package view;

import domain.Car;
import domain.Move;
import java.util.List;

public class ResultView {

    private final static String BLANK = "";


    public static void createResultView(List<Car> carList) {
        System.out.println(BLANK);
        carList.stream()
                .map(Car::getMove)
                .forEach(ResultView::drawDistance);
    }

    private static void drawDistance(Move move) {
        System.out.println(move.getCarCurrentDistance());
    }
}
