package step3.present;

import java.util.Scanner;

public class InputPresent {
    public static final String PARTICIPATES = "자동차 대수는 몇 대 인가요?";
    public static final String ITERATIONS = "시도할 회수는 몇 회 인가요?";

    private final Scanner scanner;

    public InputPresent() {
        this.scanner = new Scanner(System.in);
    }

    public int participates() {
        System.out.println(PARTICIPATES);
        return scanner.nextInt();
    }

    public int iterations() {
        System.out.println(ITERATIONS);
        return scanner.nextInt();
    }
}
