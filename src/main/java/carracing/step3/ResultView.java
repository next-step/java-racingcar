package carracing.step3;

public class ResultView {

    public void printResults(final int tryCount, final Cars cars) {
        System.out.println("실행 결과");
        for (int i = 0; i < tryCount; i++) {
            cars.moveAllCarsRandomly();
            System.out.print(cars.getAllCarsTrace());
        }
    }

}
