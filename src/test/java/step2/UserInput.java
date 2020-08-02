package step2;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

public class UserInput {

    String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        return input;
    }
}
