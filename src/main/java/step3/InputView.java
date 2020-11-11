package step3;

import java.util.Scanner;

public class InputView {

    private Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public String getCarNames() {
        return getStringFromStdin("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)");
    }

    public int getNumOfTries() {
        return getNumberFromStdin("시도할 회수는 몇 회 인가요?");
    }


    private String getStringFromStdin(String displayText) {
        return getFromStdin(displayText);
    }

    private int getNumberFromStdin(String displayText) {
        String value = getFromStdin(displayText);
        return Integer.valueOf(value);
    }

    private String getFromStdin(String displayText){
        System.out.println(displayText);
        return scanner.nextLine();
    }

    @Override
    protected void finalize() throws Throwable {
        this.scanner.close();
        super.finalize();
    }

}
