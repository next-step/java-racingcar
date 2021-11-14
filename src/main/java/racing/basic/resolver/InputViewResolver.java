package racing.basic.resolver;

import java.util.Scanner;

public class InputViewResolver {

    private static final Scanner SCANNER = new Scanner(System.in);

    public int takeInput() {
        return SCANNER.nextInt();
    }
}
