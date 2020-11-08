package racingcar.view;

import racingcar.asset.CarGroupConst;
import racingcar.asset.InputViewConst;
import racingcar.domain.model.Car;
import racingcar.exeption.BadMaxRaceException;
import racingcar.exeption.BadNameCsvException;

import java.util.Scanner;

public class InputView {
    // NOTE: Scanner 는 thread-unsafe 하므로 싱글톤 패턴을 적용한다.
    private Scanner scanner;

    private InputView() {
        scanner = new Scanner(System.in);
    }

    public static InputView getInstance() {
        return SingletonHelper.instance;
    }

    protected boolean validateNameCsv(String nameCsv) {
        String[] nameArr = nameCsv.split(CarGroupConst.NAME_SPLIT_REGEX);
        boolean validation = true;
        try {
            for (String name : nameArr) {
                validation &= Car.validateName(name);
            }
        } catch (Exception e) {
            throw new BadNameCsvException();
        }
        return validation;
    }

    protected boolean validateMaxRace(String maxRace) {
        int maxRaceNum = 0;
        try {
            maxRaceNum = Integer.parseInt(maxRace);
        } catch (Exception e) {
            throw new BadMaxRaceException();
        }
        boolean isValid = maxRaceNum > InputViewConst.MAX_RACE_BIGGER_THAN;
        if (!isValid) {
            throw new BadMaxRaceException();
        }
        return true;
    }

    public String askNames() {
        System.out.println(InputViewConst.ASK_CARS);
        String nameCsv = scanner.nextLine();
        validateNameCsv(nameCsv);
        return nameCsv;
    }

    public int askMaxRaceNum() {
        System.out.println(InputViewConst.ASK_HOW_MANY_RACES);
        String maxRace = scanner.nextLine();
        validateMaxRace(maxRace);
        return Integer.parseInt(maxRace);
    }

    private static class SingletonHelper {
        private static final InputView instance = new InputView();
    }
}
