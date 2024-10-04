package racingcar.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static Scanner SCANNER = new Scanner(System.in);

    public static List<String> inputNamesOfCar() {
        List<String> nameList = new ArrayList<>();
        String [] names = SCANNER.useDelimiter(",").nextLine().split(",");
        return Arrays.asList(names);
    }
    public static int inputTimesOfRun() {
        return SCANNER.useDelimiter("").nextInt();
    }
}