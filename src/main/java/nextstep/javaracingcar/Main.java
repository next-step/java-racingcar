package nextstep.javaracingcar;

import nextstep.javaracingcar.view.InputSupplier;
import nextstep.javaracingcar.view.InputView;
import nextstep.javaracingcar.view.OutputConsumer;
import nextstep.javaracingcar.view.ResultView;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        final Scanner scanner = new Scanner(System.in);
        final InputSupplier inputSupplier = scanner::nextLine;
        final OutputConsumer outputConsumer = System.out::println;

        final InputView inputView = new InputView(inputSupplier, outputConsumer);
        final ResultView resultView = new ResultView(outputConsumer);

        final CarRacingGameConsoleLauncher launcher = new CarRacingGameConsoleLauncher(inputView, resultView);

        launcher.run();
    }
}
