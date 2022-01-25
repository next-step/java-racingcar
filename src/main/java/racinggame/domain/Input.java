package racinggame.domain;

public class Input {

    private static final String SEPARATOR = ",";

    private Input() {}

    public static String[] getCarNames() {
        String[] carNames;

        while (true) {
            String inputCarNames = inputCarNames();
            carNames = splitNameByComma(inputCarNames);

            try {
                Validator.validatePossibleToStart(carNames);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return carNames;
    }

    private static String inputCarNames() {
        System.out.println("경주할 자동차 이름을 ','로 구분해서 입력하세요.(2대 이상)");
        return removeBlank(Utils.getInput());
    }

    private static String[] splitNameByComma(String inputCarNames) {
        return inputCarNames.split(SEPARATOR);
    }

    private static String removeBlank(String trial) {
        return trial.replaceAll("\\s+", "");
    }

    public static int getTrial() {
        String trial;

        while (true) {
            trial = inputTrial();

            try {
                Validator.isNumber(trial);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return Integer.parseInt(trial);
    }

    private static String inputTrial() {
        System.out.print("시도 횟수를 입력해 주세요: ");
        return removeBlank(Utils.getInput());
    }
}
