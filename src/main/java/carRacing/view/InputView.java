package carRacing.view;

import carRacing.utils.StringUtils;
import com.google.common.base.Strings;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {

    public String[] inputRaceCars() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        verifyInputString(input);
        return StringUtils.sptingSplitByComma(input);
    }

    private void verifyInputString(String input) {
        if(Strings.isNullOrEmpty(input)) {
            throw new InputMismatchException("공백을 입력할 수 없습니다. 자동차명을 (,)를 기준으로 입력해야 합니다.");
        }
    }

    public int inputNumberOfLaps() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }


}
