package view;

import java.util.stream.Collectors;

import domain.Car;
import domain.RacingGame;
import domain.Winners;

public class OutputView {
    private final StringBuilder stringBuilder = new StringBuilder();

    public void printProcedure(RacingGame racingGame) {
        stringBuilder.append("실행 결과\n");
        int round = racingGame.getRound();
        for (int i = 0; i < round; i++) {
            racingGame.moveByRandomly();
            racingGame.getGameStats()
                .forEach((name, position) -> {
                    stringBuilder.append(name).append(" : ").append("-".repeat(position)).append("\n");
                });
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder);
    }

    public void printWinners(Winners winners) {
        String JoinedName = winners.getCars()
            .stream()
            .map(Car::getName)
            .collect(Collectors.joining(", "));
        System.out.println(JoinedName + "가 최종 우승했습니다.");
    }
}
