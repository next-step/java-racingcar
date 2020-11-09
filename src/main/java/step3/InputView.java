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
        try {
            boolean isNumber = false;
            String inputValue = null;
            do {
                System.out.println(displayText);

                inputValue = scanner.nextLine();
                if (numberPropertyValidator.validate(inputValue)) {
                    isNumber = true;
                } else {
                    System.out.println("error) 1 이상 숫자만 입력가능합니다.");
                }
            } while (!isNumber);

            return Integer.valueOf(inputValue);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e.getCause() == null ? e : e.getCause());
        }
    }

    @Override
    protected void finalize() throws Throwable {
        this.scanner.close();
        super.finalize();
    }

}
