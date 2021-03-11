package study.step4.ui;

import java.util.List;
import java.util.StringJoiner;

import study.step4.model.Car;

public class ResultView {
    public ResultView() {
    }

    public void printRacingResult(List<Car> carList, String printToken) {
        carList.stream()
            .forEach(car -> {
                System.out.println(car.getName() + " : " + convertPositionToPrintToken(car.getPosition(), printToken));
            });
    }

    private String convertPositionToPrintToken(int position, String printToken) {
        return new String(new char[position]).replace("\0", printToken);
    }

    public void printRacingWinner(List<Car> winners, String message) {
        StringJoiner winner = new StringJoiner(",");
        winners.forEach(car -> winner.add(car.getName()));
        System.out.println(winner.toString() + message);
    }
}
