package racingCar;

public class ResultView {
    ResultView() {
        System.out.println("실행 결과");
    }

    public void print(int num) {
        for (int i = 0; i < num; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
