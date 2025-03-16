import com.sun.source.tree.UsesTree;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int getTryCount() {
        System.out.print("시도할 회수는 몇 회 인가요?");
        return scanner.nextInt();
    }

    public static int getCarNum() {
        System.out.print("자동차 대수는 몇 대 인가요?");
        return scanner.nextInt();
    }

    public static void closeScanner() {
        scanner.close();
    }
}
