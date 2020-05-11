package racingcar;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingGameLauncher {
    private final InputView inputView = new InputView();

    public void play(){
        int numberOfCar = inputView.requestNumberOfCar();
        int time = inputView.requestTime();

        RacingGame racingGame = RacingGameFactory.newRacingGame(numberOfCar);
        print(racingGame, time);
    }

    private void print(RacingGame racingGame, int time) {
        System.out.println("실행 결과");
        System.out.println(createResult(racingGame, time));
    }

    private String createResult(RacingGame racingGame, int time) {
        return IntStream.range(0, time)
            .mapToObj(value -> {
                racingGame.tryMove();;
                return new ResultView(racingGame.getPositions()).print();
            })
            .collect(Collectors.joining("\n\n"));
    }

    public static void main(String[] args){
        new RacingGameLauncher().play();
    }
}
