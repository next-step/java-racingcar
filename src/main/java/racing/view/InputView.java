package racing.view;

import java.util.Scanner;

public class InputView {

    public String inputCarname() {
        Scanner in = new Scanner(System.in);

        System.out.println("자동차 이름을 입력하세요(쉼표(,)구분");
        String names = in.nextLine();

        return names;

    }

    public int inputRound() {
        Scanner in = new Scanner(System.in);

        System.out.println("시도할 회수를 입력하세요!");
        int round = Integer.parseInt(in.nextLine());

        return round;
    }

}
