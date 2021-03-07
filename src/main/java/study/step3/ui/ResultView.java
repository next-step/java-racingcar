package study.step3.ui;

import java.util.List;

import study.step3.model.Car;

public class ResultView {
    public ResultView() {
    }

    public void printRacingResult(List<Car> carList, String printToken) {
        carList.stream()
            .map(Car::getPosition)
            .forEach(position -> System.out.println(convertPositionToPrintToken(position, printToken)));
    }

    private String convertPositionToPrintToken(int position, String printToken) {
        return new String(new char[position]).replace("\0", printToken);
    }
}
