package racingcar.view;

import racingcar.dto.Result;
import racingcar.dto.Winner;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ConsoleRacingCarView implements RacingCarView {

    private final String CAR_NAMES_PROMPT = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private final String COUNT_PROMPT = "시도할 회수는 몇회인가요?";
    private final String PLAY_RESULT = "\n실행 결과\n";
    private final String WINNER_MESSAGE = "가 최종 우승했습니다.";
    private final String JOIN_DELIMITER = " ,";
    private final String SCORE_SYMBOL = "-";
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void printCarNamesPrompt() {
        System.out.println(CAR_NAMES_PROMPT);
    }

    @Override
    public void printCountPrompt() {
        System.out.println(COUNT_PROMPT);
    }

    @Override
    public void printResults(List<List<Result>> results) {
        System.out.println(PLAY_RESULT);
        for (List<Result> result : results) {
            printResult(result);
        }
    }

    @Override
    public void printResult(List<Result> result) {
        String output = result.stream()
                .map(car -> car.getName() + " : " + SCORE_SYMBOL.repeat(car.getScore()))
                .collect(Collectors.joining(System.lineSeparator()));
        System.out.println(output + "\n");
    }

    @Override
    public void printWinners(List<Winner> winners) {
        String output = winners.stream()
                .map(Winner::getName)
                .collect(Collectors.joining(JOIN_DELIMITER));

        System.out.println(output + WINNER_MESSAGE);
    }

    @Override
    public String read() {
        return scanner.nextLine();
    }
}
