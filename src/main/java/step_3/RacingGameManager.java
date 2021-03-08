package step_3;


/*
* Racing Game Manager
*
* */
public class RacingGameManager {

    public static void main(String [] args) {
        GameInputResult inputResult = new GameInputView.Builder()
                .enterCarsMessage("자동차 대수는 몇 대 인가요?")
                .executionCountMessage("시도할 회수는 몇 회 인가요?")
                .build()
                .initialized();

        System.out.println("실행 결과");
        GameResultView.printRacingGames(new RacingGame.Builder()
                .enterCars(inputResult.enterCars())
                .execution(inputResult.executionCount())
                .build()
                .startRacing());

        RacingGame racingGame = new RacingGame.Builder()
                .enterCars(inputResult.enterCars())
                .execution(inputResult.executionCount())
                .build();

        RacingResult currentLaps = racingGame.standby();
        System.out.println("Game Start");
        GameResultView.printRacingResult(currentLaps.gameStatus());
        System.out.println("Start!!");
        while (!currentLaps.complete()) {
            currentLaps = racingGame.run(currentLaps.gameStatus());
            GameResultView.printRacingResult(currentLaps.gameStatus());
            System.out.print("\n");
        }
    }

}
