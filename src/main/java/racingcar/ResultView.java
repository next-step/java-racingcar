package racingcar;

public class ResultView {

    public void printResult(Car[] cars) {
        for (Car car : cars) {
            for (int i = 0; i < car.getCntMove(); i++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }
}
