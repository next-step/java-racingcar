package Step1;

import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Baseball baseball = new Baseball();
        String computer = gen_computer();

        int strike = 0;
        while (strike != 3) {
            strike = interact_console(baseball, computer);
        }
    }

    private static int interact_console(Baseball baseball, String computer) {
        System.out.println("숫자를 입력해 주세요 : ");
        String user = scanner.nextLine();

        Result res = baseball.play(computer, user);

        if (res.ball == 0 && res.strike == 0){
            System.out.println("낫싱");
        } else {
            System.out.println(res.ball + "볼 " + res.strike + "스트라이크");
        }
        System.out.println(res.ball + "볼 " + res.strike + "스트라이크");

        return res.strike;
    }

    private static String gen_computer() {
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        boolean[] avail = new boolean[] {true,true,true,true,true,true,true,true,true};

        int gen_count = 0;
        while(gen_count < 3){
            gen_count += gen_one_ball(avail, sb, rand);
        }

        return sb.toString();
    }

    private static int gen_one_ball(boolean[] avail, StringBuilder sb, Random rand) {
        int digit = rand.nextInt(9) + 1;

        if (!avail[digit]) {
            return 0;
        }

        sb.append(digit);
        avail[digit] = false;

        return 1;
    }
}