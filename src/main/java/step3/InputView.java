package step3;

import java.util.Scanner;

public class InputView {

    private Scanner scanner;

    private CarRacingNumberPropertyValidator numberPropertyValidator = new CarRacingNumberPropertyValidator();

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public int getNumOfCars() {
        return getNumberFromStdin("자동차 대수는 몇 대 인가요?");
    }

    public int getNumOfTries() {
        return getNumberFromStdin("시도할 회수는 몇 회 인가요?");
    }

    private int getNumberFromStdin(String displayText) {
        System.out.println(displayText);

        String inputValue = scanner.nextLine();
        numberPropertyValidator.validate(inputValue);

        return Integer.valueOf(inputValue);
    }

    @Override
    protected void finalize() throws Throwable {
        this.scanner.close();
        super.finalize();
    }

}
