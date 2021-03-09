package step3.study.view;

import step3.study.domain.Car;
import step3.study.domain.Cars;
import step3.study.domain.ResponseRacingDTO;

import java.util.List;

public class ResultView {
    public void showResultView(Cars cars) {
        System.out.println("실행결과");
        for (Car car : cars.getCarList()) {
            printDistance(car);
            System.out.println();
        }
    }

    private void printDistance(Car car) {
        List<String> recodeDistance = car.getRecodeDistance();
        for (String distance : recodeDistance) {
            System.out.println(distance);
        }
    }
}
