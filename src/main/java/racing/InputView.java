package racing;

public class InputView {

    private InputView() {

    }

    public static void render(int move) {
        for (int i = 0; i < move; i++) {
            System.out.print("-");
        }
        System.out.println(" ");
    }
}