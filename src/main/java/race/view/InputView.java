package race.view;

import java.util.Scanner;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Util.println;

public class InputView {
    public static int getCarNumber() {
        println("자동차 대수는 몇 대 인가요?");

        Scanner scanner = new Scanner(System.in);

        return scanner.nextInt();
    }

    public static int getRunCount() {
        println("시도할 회수는 몇 회 인가요?");

        Scanner scanner = new Scanner(System.in);

        return scanner.nextInt();
    }
}
