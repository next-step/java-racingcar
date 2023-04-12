package step3;

import java.util.List;
import java.util.Scanner;

public class ResultView {

    public void printResult(List<Car> cars) {
        System.out.println("실행 결과");
        cars.forEach((car -> {
            printCarPosition(car);
            System.out.println();
        }));
    }

    private void printCarPosition(Car car) {
        for(int i =0 ; i< car.getPosition(); i++) {
            System.out.print("-");
        }
    }
}
