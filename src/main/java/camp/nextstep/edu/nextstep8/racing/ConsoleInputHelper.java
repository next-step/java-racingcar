package camp.nextstep.edu.nextstep8.racing;

import java.util.Scanner;
import java.util.function.Function;

public class ConsoleInputHelper {
    private static final Scanner scanner = new Scanner(System.in);

    private ConsoleInputHelper(){
    }

    public static <R> R getValue(String inputGuideMessage, Function<Scanner, R> resolver) {
        System.out.print (inputGuideMessage + "\t: " );
        return resolver.apply(scanner);
    }
}

