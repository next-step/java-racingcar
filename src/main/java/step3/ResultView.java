package step3;

public class ResultView {

    public ResultView() {
        System.out.println();
        System.out.println("실행결과");
    }

    public void showResult(CarList carList) {
        carList.getCarList().forEach(it -> {
            printPosition(it.getCurrentPosition());
        });
        System.out.println();
    }

    private void printPosition(int positions) {
        for (int i = 0; i <= positions; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
