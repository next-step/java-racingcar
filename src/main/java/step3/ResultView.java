package step3;

public class ResultView {

    private ResultView() {
        System.out.println("\n실행 결과");
    }

    public static void print(Car car) {
        System.out.println(car.makePositionStatus());
    }
}
