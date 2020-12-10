package step3;

import java.util.List;
import java.util.stream.Collectors;

public class App {

    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();

        List<String> carNameList = inputHandler.getCarList();
        int roundCount = inputHandler.getRoundCount();
        RacingGame game = new RacingGame(carNameList);

        for (int i = 0; i < roundCount; i++) {
            game.play();
            System.out.println(game.getPlayResult());
        }

        System.out.println(String.join(",",
                game.getWinners()
                .stream().map(Car::getName)
                .collect(Collectors.toList())) + "가 최종 우승했습니다");
    }

}
