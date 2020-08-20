package carracing.view;

import carracing.domain.car.Car;
import carracing.domain.car.Cars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OutputView {

    public void getResultView(List<Cars> carsList) {
        carsList.stream()
                .map(Cars::getCars)
                .forEach(carList -> getCarListForNewLine(carList));
    }

    void getCarListForNewLine(List<Car> carList) {
        carList.stream()
                .forEach(car -> showResultByCar(car));
        System.out.println("");
    }

    private void showResultByCar(Car car) {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < car.getPosition(); i++) {
            stringBuilder.append("-");
        }
        System.out.println(car.getCarName() + " : " + stringBuilder);
    }

    public void viewWinner(String winnerName) {
        System.out.println(winnerName + "가 최종 우승했습니다.");
    }
}
