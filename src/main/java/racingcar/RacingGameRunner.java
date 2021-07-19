package racingcar;

class RacingGameRunner {
    public static void main(String[] args) {
        RacingGamePrinter.print(
                RacingGameCore.of(
                        RacingGameScanner.enterCarCount(),
                        RacingGameScanner.enterStageCount()
                ).run()
        );
    }
}
