package racing.view;

import java.util.Scanner;

public class InputView
{
    private static final Scanner scanner = new Scanner(System.in);
    private static final String COMMA = ",";

    private InputView() {}

    public static String[] writeCarName()
    {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return scanner.next().split(COMMA);
    }

    public static int writeTryNumber()
    {
        System.out.println("시도할 회수는 몇 회 인가요?");
        while (true)
        {
            try
            {
                return scanner.nextInt();
            }
            catch (NumberFormatException e)
            {
                System.out.println("숫자를 입력하세요");
            }
        }
    }
}
