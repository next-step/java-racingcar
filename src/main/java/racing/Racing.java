package racing;

import java.util.Scanner;

public class Racing {

    public static void main(String args[]) {

        System.out.println("자동차 대수는 몇 대 인가요?");

        Scanner carNumInput = new Scanner(System.in);
        String carNumValue = carNumInput.nextLine();
        int carNum = carNumInput.nextInt();

        System.out.println("시도할 회수는 몇 회 인가요?");

        Scanner tryNumInput = new Scanner(System.in);
        String tryNumValue = tryNumInput.nextLine();
        int tryNum = tryNumInput.nextInt();

    }
}
