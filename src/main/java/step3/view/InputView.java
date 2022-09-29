package step3.view;

import java.util.Scanner;

public class InputView
{
    private static InputView inputView;
    private static final Scanner scanner = new Scanner(System.in);
    private static final String COMMA = ",";

    private InputView() {}

    public static InputView getInstance()
    {
        if (inputView == null)
        {
            inputView = new InputView();
        }
        return inputView;
    }

    public String[] carName()
    {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return scannerArray();
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

    private String[] scannerArray()
    {
        return scanner.next().split(COMMA);
    }
}
