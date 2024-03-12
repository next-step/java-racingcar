package carRacing.view;

import car.Car;

import java.util.List;

public class ResultView {

    private List<Car> cars;

    public ResultView(List<Car> cars) {
        this.cars = cars;
    }

    public void show() {
        System.out.println("실행결과");
        for (Car car : cars) {
            System.out.println("| " + car.getLocation());   //시작 위치를 확인하기 위해 "|" 추가
        }
        System.out.println();
    }
}
