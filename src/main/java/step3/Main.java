package step3;

public class Main {
    public static void main(String[] args) {
        try {
            InputDto input = InputView.input();
            Racing racing = new Racing(input);
            racing.racingCarStart();

        } catch (IllegalArgumentException e) {
            System.out.println("에러는 -> " + e);
        }
    }
}
