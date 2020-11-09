package step3;

import java.util.Scanner;

public class InputView {

    private Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public int getNumberFromStdin(String displayText){
        int value = -1;
        try {
            boolean isNumber = false;
            while (!isNumber) {
                System.out.println(displayText);
                value = convertLineToNumber(scanner.nextLine());
                if (value > 0) isNumber = true;
            }
            return value;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e.getCause() == null ? e : e.getCause());
        }
    }

    private int convertLineToNumber(String line) {
        try {
            int parsedValue = Integer.parseInt(line);
            if (parsedValue <= 0) {
                System.out.println("error) 1 이상 숫자만 입력가능합니다.");
                return -1;
            }
            return parsedValue;
        } catch (NumberFormatException e) {
            System.out.println("error) 1 이상 숫자만 입력가능합니다.");
            return -1;
        }
    }

    @Override
    protected void finalize() throws Throwable {
        this.scanner.close();
        super.finalize();
    }
}
