package racing;

public class ResultView {

    public ResultView() {
        System.out.println("\n실행결과");
    }

    public void printResult(RacingCars racingCars) {
        StringBuilder result = new StringBuilder();
        for (Car car : racingCars.getCars()) {
            result.append("-".repeat(car.getPosition())).append("\n");
        }
        result.append("\n");
        System.out.print(result);
    }

}
