package racing.view;

import java.util.Scanner;

public class InputView {
    public static final String STR1 = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)로 구분)";
    public static final String STR2 = "시도할 회수는 몇 회 인가요?";
    public static final String CAR_NAME_GUBUN = ",";

    public static final Scanner scanner = new Scanner(System.in);

    public String carInput() {
        System.out.print(STR1);
        return strInput();
    }

    public int cntInput() {
        System.out.print(STR2);
        return intInput();
    }

    private static int intInput() {
        int input = scanner.nextInt();
        if (input < 0) {
            throw new IllegalArgumentException("음수는 허용하지 않습니다.");
        }
        return input;
    }

    private static String strInput(){
        String name = scanner.nextLine();
        if(!name.contains(CAR_NAME_GUBUN)){
            throw new IllegalArgumentException("구분자를 포함해주세요.");
        }
        return name;
    }
}
