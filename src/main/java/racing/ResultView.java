package racing;

public class ResultView {

    public void printTitle() {
        System.out.println("\n실행 결과");
    }

    public void printBlank() {
        System.out.println();
    }

    public void printResult(int num) {
        for(int i=0 ; i<num ; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
