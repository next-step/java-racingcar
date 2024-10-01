package racingcar;

public class Main {
    public static void main(String[] args) {
        InputView.getUserInput();
        int match = RacingCar.getInstance().getMatch();
        System.out.println("실행 결과");
        for(int i = 0; i < match; i++){
            RacingCar.getInstance().startMatch();
            ResultView.printCars();
        }
    }
}
