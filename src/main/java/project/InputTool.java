package project;

import com.sun.istack.internal.NotNull;

import java.util.Scanner;

public class InputTool {

    private Scanner mScanner;

    public InputTool() {
        mScanner = new Scanner(System.in);
    }

    @NotNull
    public String readLine() {
        String inputText = mScanner.nextLine();

        if (inputText == null || inputText.isEmpty()) {
            throw new IllegalArgumentException("입력된 수식이 없습니다. 다시 입력해주세요.");
        }

        return inputText;
    }

    public Integer readLineToInt() throws NumberFormatException {
        return Integer.valueOf(readLine());
    }
}
