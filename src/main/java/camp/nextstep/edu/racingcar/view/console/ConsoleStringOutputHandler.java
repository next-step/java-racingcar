package camp.nextstep.edu.racingcar.view.console;

import camp.nextstep.edu.racingcar.view.OutputHandler;

public class ConsoleStringOutputHandler implements OutputHandler<String> {

    @Override
    public void handle(String output) {
        System.out.println(output);
    }
}
