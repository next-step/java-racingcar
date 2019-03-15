package racinggame.view;

import util.StringUtils;

import java.util.*;

public class InputView {

    static final String CONSOLE_CARNAME_DELIMETER = ",";
    public static final String WEB_CARNAME_DELIMETER = " ";

    private Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public List<String> getCarNames() {
        showCarNamesInputMessage();
        String[] carNames = getCarNames(getInputLine(), CONSOLE_CARNAME_DELIMETER);
        validateCarNames(carNames);

        return new ArrayList(Arrays.asList(carNames));
    }

    void showCarNamesInputMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    public String[] getCarNames(String inputLine) {
        return getCarNames(inputLine, CONSOLE_CARNAME_DELIMETER);
    }

    public static String[] getCarNames(String inputLine, String delimeter) {
        String[] carNames = inputLine.split(delimeter);
        return carNames;
    }

    String getInputLine() {
        return scanner.nextLine();
    }

    void validateCarNames(String[] carNames) {
        if( StringUtils.isNullOrEmptyArray(carNames) ||
            StringUtils.isNullOrEmpty(carNames[0])) {
            throw new InputMismatchException("자동차 이름을 입력하셔야 합니다.");
        }
    }

    public Integer getNumberOfTries() {
        showNumberOfTriesInputMessage();
        Integer numberOfTries = getNumberOfTries(getInputLine());
        validateNumberOfTries(numberOfTries);
        return numberOfTries;
    }

    void showNumberOfTriesInputMessage() {
        System.out.println("시도할 회수는 몇 회 인가요?");
    }

    public static Integer getNumberOfTries(String inputLine) {
        Integer numberOfTries = null;
        try {
            numberOfTries = Integer.parseInt(inputLine);
        } catch(Exception e) {
            e.printStackTrace();
        }

        return numberOfTries;
    }

    void validateNumberOfTries(Integer numberOfTries) {
        if(numberOfTries == null || numberOfTries <= 0) {
            throw new InputMismatchException("0보다 큰 숫자를 입력 해 주세요.");
        }
    }
}