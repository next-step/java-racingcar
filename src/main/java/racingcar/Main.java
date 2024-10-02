package racingcar;

public class Main {
    public static void main(String[] args) {
        RacingCar racingCar = new RacingCar();
        InputView.getUserInput(racingCar);
        int match = racingCar.getMatch();
        System.out.println("실행 결과");
        for(int i = 0; i < match; i++){
            racingCar.startMatch();
            ResultView.printCars(racingCar);
        }
    }
}
