package racing;

public class RacingCarGame {

    public static void main (String[] arg) {
        InputView.display();

        GameSetup gameSetup = new GameSetup(InputView.numCar, InputView.numAttempt);

        for (int i = 0; i < InputView.numAttempt; i++) {
            gameSetup.moveCar();

            System.out.println("******** "+(i+1)+" 라운드 ********"); // 라운드별 구분자
            ResultView.display(gameSetup.cars);
        }
    }
}
