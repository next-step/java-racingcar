package racingcar;

public class ResultView {

    private ResultView() {
    }
    public static void printStartResult(){
        System.out.println("실행 결과");
    }
    public static void printCars(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.println(car.getShowDistance());
        }
    }
}
