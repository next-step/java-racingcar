package carrace.ui.input.scanner;

import java.util.Scanner;

public class CountInputScanner implements InputScanner<Integer> {

    private static final Scanner scanner = new Scanner(System.in);

    @Override
    public Integer scan() {
        return Integer.parseInt(scanner.nextLine());
    }

    @Override
    public Integer repeatScan(String message) {
        int count;
        while(true) {
            try {
                System.out.println(message);
                count = this.scan();
                break;
            } catch (NumberFormatException ex) {
                System.out.println("입력은 숫자만 가능합니다.");
            }
        }
        return count;
    }
}
