package step3.view;

import step3.model.GameRound;
import step3.model.RaceGame;
import step3.model.RandomCommander;
import step3.present.Presenter;

import java.util.Scanner;

public class ClientView {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");
        int participantCar = scanner.nextInt();

        System.out.println("시도할 횟수는 몇 회 인가요?");
        int round = scanner.nextInt();

        GameRound gameRound = new GameRound(participantCar, round);
        Presenter presenter = new Presenter(new RenderingView(), new RandomCommander());

        RaceGame game = presenter.createGame(gameRound);
        presenter.gameStart(game);

    }

}
