/*
 * 클래스 이름
 * 출력 메세지 뷰
 * 버전 정보
 * 1.0
 * 날짜
 * 2020.11.01
 * 저작권 주의
 */

package view;

import model.Car;

import java.util.List;
import java.util.stream.IntStream;

public class ResultView {
    public void printCars (List<Car> cars) {
        cars.forEach(car -> {
            printCar(car);
            System.out.println();
        });

        System.out.println();
    }

    private void printCar (Car car) {
        IntStream.range(0, car.getPosition().getPosition()).mapToObj(i -> "-").forEach(System.out::print);
    }
}
