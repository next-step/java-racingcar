package nextstep.javaracingcar;

import java.util.List;
import java.util.Random;

import static nextstep.javaracingcar.PositiveNumber.from;

public class CarRacingGameConsoleLauncher {

    private final InputSupplier inputSupplier;
    private final OutputConsumer outputConsumer;

    public CarRacingGameConsoleLauncher(InputSupplier inputSupplier, OutputConsumer outputConsumer) {
        this.inputSupplier = inputSupplier;
        this.outputConsumer = outputConsumer;
    }

    public void run() {
        final int carCount = inputCarCount();
        final int roundCount = inputRoundCount();

        final Random random = new Random();
        final CarEngine randomMoveCarEngine = new OneOrZeroEngine(() -> random.nextInt(10), 4);
        final CarRacingGame carRacingGame = new CarRacingGame(from(carCount), new Round(roundCount), randomMoveCarEngine);

        printEmptyLine();
        this.outputConsumer.write("실행 결과");

        printResult(carRacingGame.result());
        while (carRacingGame.hasNextRound()) {
            printResult(carRacingGame.runRound());
        }
    }

    private int inputCarCount() {
        outputConsumer.write("자동차 대수는 몇 대 인가요?");
        final String input = inputSupplier.read();
        return Integer.parseInt(input);
    }

    private int inputRoundCount() {
        outputConsumer.write("시도할 횟수는 몇 회 인가요?");
        final String input = inputSupplier.read();
        return Integer.parseInt(input);
    }

    private void printEmptyLine() {
        outputConsumer.write("");
    }

    private void printResult(List<CarDashboard> dashboards) {
        for (CarDashboard dashboard : dashboards) {
            final StringBuffer sb = new StringBuffer("-");
//            dashboard.distance().toItera();
            outputConsumer.write(sb.toString());
        }
        printEmptyLine();
    }
}
