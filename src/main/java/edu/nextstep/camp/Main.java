package edu.nextstep.camp;

public class Main {
    public static void main(String[] args) {
        final InputView input = new InputView();

        final int cars = input.inputPositiveNumber("자동차 대수는 몇 대 인가요?");
        final int turns = input.inputPositiveNumber("시도할 회수는 몇 회 인가요?");

        final ResultView result = new ResultView(turns);

        final Race race = Race.of(cars, turns);
        while (!race.isEnded()) {
            race.process();
            result.printResult(race.gameResult());
        }
    }
}
