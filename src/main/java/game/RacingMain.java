package game;

public class RacingMain {

    public static void main(String args[]) {

        int cars = InputView.create().getNumberOfCars(); // 자동차 수 입력

        int count = InputView.create().getRacingCount(); // 시도 횟수 입력

        RacingGame.create().racing(cars,count); //경주 게임
    }
}
