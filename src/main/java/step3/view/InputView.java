package step3.view;

import java.util.Scanner;

public class InputView
{
    private final Scanner scanner = new Scanner(System.in);

    public static InputView getInstance()
    {
        return new InputView();
    }

    public int carNumber()
    {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return scannerInt();
    }
    public int tryNumber()
    {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return scannerInt();
    }
    private int scannerInt()
    {
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
