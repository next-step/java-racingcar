package study.racingcar;

public class OutputView {

    public void printRacingResult(RacingResult racingResult) {
        racingResult.getResults()
            .forEach(this::printCarResult);
        System.out.println();

    }

    public void printCarResult(Car car) {
        System.out.printf("%s: ", car.getName());
        for (int i = 0; i <= car.getPosition(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

}
