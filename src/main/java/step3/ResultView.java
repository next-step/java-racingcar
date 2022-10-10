package step3;

public class ResultView {

    public void startView() {
        System.out.println("실행 결과");
    }

    public static void resultView(Name carName, Position position) {
        System.out.print(carName + " : ");
        for(int i = 0; i < position.currentPosition(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
