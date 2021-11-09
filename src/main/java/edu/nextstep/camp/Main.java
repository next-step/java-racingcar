package edu.nextstep.camp;

public class Main {
    private static final int NAME_LIMIT = 5;
    private static final String DELIMITER = ",";

    public static void main(String[] args) {
        final InputView input = new InputView();

        final String[] cars = input.inputCSV("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).", NAME_LIMIT, DELIMITER);
        final int turns = input.inputPositiveNumber("시도할 회수는 몇 회 인가요?");

        final ResultView result = new ResultView(turns);

        final Race race = Race.of(cars.length, turns);
        while (!race.isEnded()) {
            race.process();
            result.printResult(race.gameResult());
        }
    }
}
