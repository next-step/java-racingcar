package CarRacing.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public int getNumberOfCar(String numberStr) {
        if (emptyText(numberStr)) {
            System.out.println("자동차 대수는 몇 대 인가요?");
            numberStr = SCANNER.nextLine();
        }

        if (!isNumeric(numberStr)) {
            requestReTypeNumber();
            throw new IllegalArgumentException("check number of car");
        }

        return Integer.parseInt(numberStr);
    }

    public int getNumberOfTry(String numberStr) {
        if (emptyText(numberStr)) {
            System.out.println("시도할 횟수는 몇 회 인가요?");
            numberStr = SCANNER.nextLine();
        }

        if (!isNumeric(numberStr)) {
            requestReTypeNumber();
            throw new IllegalArgumentException("check number of try");
        }

        return Integer.parseInt(numberStr);
    }

    public boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    private static boolean emptyText(String inputText) {
        return (inputText == null) || inputText.isEmpty() || inputText.isBlank();
    }

    private static void requestReTypeNumber() {
        System.out.println("숫자로만 입력해주세요!");
    }

}
