package study.step3;

<<<<<<< HEAD
import java.util.ArrayList;
=======
>>>>>>> d1896fdcab2eb83ee20138f031ab12d323e07844
import java.util.List;
import java.util.Scanner;

public class RacingGameLauncher {
<<<<<<< HEAD
    private final static int INIT_ZERO = 0;

    private static List<Round> gameStartAllrounds(RacingGame racingGame, RandomCarMoveCondition moveCondition) {
        List<Round> rounds = new ArrayList<>();
        Round round = new Round(racingGame);
        for (int i = INIT_ZERO; i < racingGame.getTryTime(); i++) {
            if (i == INIT_ZERO){
                rounds.add(round);
                continue;
            }
            round = perRoundGame(round, moveCondition);
            rounds.add(round);
        }
        return rounds;
    }

    private static Round perRoundGame(Round round, RandomCarMoveCondition moveCondition) {
        List<Car> cars = new ArrayList<>();
        for (Car car : round.getCars()){
            cars.add(car.move(moveCondition));
        }
        return new Round(cars);
    }

    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame(InputView.inputTryTime(), InputView.inputCarNumber());

        List<Round> rounds = gameStartAllrounds(racingGame, new RandomCarMoveCondition());

        ResultView resultView = new ResultView(rounds);
        resultView.print();
    }
=======
    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        InputView inputView = new InputView(scanner);

        RacingGame racingGame = new RacingGame.RacingGameBuilder()
                .setCarNumbers(inputView.inputCarNumber())
                .setTime(inputView.inputTryTime())
                .build();

        List<Car> result = racingGame.gameStart();
        ResultView resultView = new ResultView(result);
        resultView.print();
    }

>>>>>>> d1896fdcab2eb83ee20138f031ab12d323e07844
}
