package step3to5.domain;

import step3to5.view.InputView;

import java.util.List;

public class ResultDto {
    private List<Car> cars;
    private String resultSymbol = "-";

    public ResultDto(Cars cars) {
        this.cars = cars.getCars();
        if (InputView.getSymbol() != null) {
            resultSymbol = InputView.getSymbol();
        }
    }

    public int getNumberOfCars() {
        return cars.size();
    }

    public String printResultByCar(int iterator) {
        Car car = cars.get(iterator);
        int score = car.getScore();
        String convertedScore = convertStringFromScoreNumber(score);
        return car.getName() + " : " + convertedScore;
    }

    public String convertStringFromScoreNumber(int score) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < score; i++) {
            result.append(resultSymbol);
        }
        return result.toString();
    }
}
