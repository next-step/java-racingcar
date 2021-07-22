package racing_car.step03;

public class ResultView {
    private static final String MESSAGE = "실행 결과";

    public static void print(){
        System.out.println(MESSAGE);
    }

    public static void result(String[] cars) {
        for (String car : cars) {
            System.out.println(car);
        }
        System.out.println();
    }
}
