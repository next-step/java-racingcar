package carracing.step3;

public class ResultView {

    public void printResults(final int carCount, final int tryCount, final Car[] cars) {
        System.out.println("실행 결과");

        for(int i=0; i<tryCount; i++) {
            this.moveCarAndPrintTrace(carCount, cars);
            System.out.println();
        }
        System.out.println();
    }

    private void moveCarAndPrintTrace(final int carCount, final Car[] cars) {
        for(int i=0; i<carCount; ++i) {
            cars[i].move();
            System.out.println(cars[i].moveTrace());
        }
    }

}
