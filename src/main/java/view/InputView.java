package view;

public final class InputView {

    private InputView() {
    }

    public static int inputInteger() {
        return SingletonScanner.getInstance().nextInt();
    }

    public static String inputString() {
        return SingletonScanner.getInstance().nextLine();
    }
}