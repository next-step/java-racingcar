package car;

public class Main {

    public static void main(String[] args) {
        CarRacing carRacing = new CarRacing(new InputWinnerCarView(), new ResultWinnerCarView());
        carRacing.start();
    }
}
