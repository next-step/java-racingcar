package racingcar.view;

import static racingcar.model.utils.info.RacingGameInfo.RACING_CAR_INPUT;
import static racingcar.model.utils.info.RacingGameInfo.RACING_TRY_INPUT;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class RacingCarUserConsole {

    private static final Scanner scanner = new Scanner(System.in);
    private static final BufferedWriter log = new BufferedWriter(
        new OutputStreamWriter(System.out));

    public static String inputCarName() throws IOException {
        log.write(RACING_CAR_INPUT);
        log.flush();
        return scanner.nextLine();
    }

    public static int inputRacingTry() throws IOException {
        log.write(RACING_TRY_INPUT);
        log.flush();
        return Integer.valueOf(scanner.nextLine());
    }
}

