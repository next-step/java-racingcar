package step4.view;

public class ResultView {

    public void startResultView() {
        System.out.println("실행 결과");
    }

    public void result(String carName, int location) {
        System.out.print(carName + " : ");
        for(int i = 0; i < location; i ++) {
            System.out.print("-");
        }
        System.out.println();

    }
}
