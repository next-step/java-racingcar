package step3;

public class ResultView {

    public final String GO = "-";

    public void result(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(GO);
        }
        System.out.println("");
    }
}
