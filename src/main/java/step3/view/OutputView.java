package step3.view;

public class OutputView {

    public void outputCarPrint() {
        System.out.println("자동차 대수는 몇 대 인가요?");
    }

    public void outputMovePrint() {
        System.out.println("시도할 회수는 몇 회 인가요?");
    }

    public void printCar(int position) {
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < position; i++) {
            result.append("-");
        }
        System.out.println(result);
    }
}
