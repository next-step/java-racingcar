package StringInputCalcualtor;

import lombok.AllArgsConstructor;

import java.util.Scanner;

@AllArgsConstructor
public class ArgumentCollector {
    private String[] args;

    public String collect() {
        try (Scanner in = new Scanner(System.in)) {
            if (args.length > 0) {
                return String.join(" ", args);
            } else {
                System.out.println("문자열 수식을 입력 하세요");
                return in.nextLine();
            }
        }
    }
}
