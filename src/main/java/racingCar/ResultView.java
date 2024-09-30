package racingCar;

public class ResultView {

    private static final String RESULT_MESSAGE = "실행결과";

    public static void printResultMessage(){
        System.out.println(RESULT_MESSAGE);
    }

    public static void printCars(Car[] cars) {
        for (Car car : cars) {
            car.run();
        }
    }

    private ResultView(){}
}
