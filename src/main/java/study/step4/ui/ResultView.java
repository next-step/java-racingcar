package study.step4.ui;

import java.util.List;

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
}
