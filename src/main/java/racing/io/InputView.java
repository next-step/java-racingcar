package racing.io;

import racing.model.Splitter;

import java.util.List;
import java.util.Scanner;

public class InputView {

    public static int getCarCount() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return new Scanner(System.in).nextInt();
    }

    public static int getRaceCount() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return new Scanner(System.in).nextInt();
    }


    public static List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return Splitter.spiltWithComma(new Scanner(System.in).nextLine());
    }

}
