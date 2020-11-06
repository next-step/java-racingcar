package racingcar.view;

import racingcar.model.GameRound;
import racingcar.model.RaceGame;
import racingcar.model.RandomCommander;
import racingcar.present.Presenter;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ClientView {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");
        int participantCar = scanner.nextInt();

        System.out.println("시도할 횟수는 몇 회 인가요?");
        int round = scanner.nextInt();

        GameRound gameRound = new GameRound(participantCar, round);
        Presenter presenter = new Presenter(new RenderingView(),  new RaceGame(gameRound, new RandomCommander()));

        IntStream.range(0, round)
                .forEach(i -> presenter.gameStart());


    }

}
