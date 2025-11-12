package racinggame.ui;

import static java.lang.Integer.parseInt;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    // 여기서 정수로 변환 하는 이유는 형변환의 책임과 예외헨들링이 비즈니스 코드에 있다고 생각하지 않아서 입니다.
    // 다만 이런경우 항상 함수의 재사용성과 관련해서도 고견 주시면 감사하겠습니다
    public static int inputInt() {
        String input = SCANNER.nextLine();

        // -> 아래 유효성 검사 코드를 해당 메서드에 넣는순간.. 재사용성은 현격히 떨어짐.
        // 빈값인 경우 특정 동작하도록 바뀌면? or 새로운 기능이 들어오면?
        // 제거하면 편해서 제거했는데.. 해당 함수를 호출하는곳에서 아래 유효성검사 코드를 보고 호출부에서 따로 검사를 진행안해서 문제가 발생하면? --> 이걸 방지하기 위해선?
        validBlank(input);

        // 실무라면 음수인 경우도 추가해야한다
        if (!Character.isDigit(input.charAt(0))) {
            throw new IllegalArgumentException("입력값이 숫자가 아닙니다.");
        }

        return parseInt(input);
    }

    public static String inputString() {
        String input = SCANNER.nextLine();

        validBlank(input);

        return input;
    }

    private static void validBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("입력값이 빈값 입니다.");
        }
    }
}
