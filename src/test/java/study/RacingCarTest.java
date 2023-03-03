package study;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Scanner;

public class RacingCarTest {

    @Test
    void scanTest() {

        String input = "1 + 2 k 3";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Scanner scan = new Scanner(System.in);
        input = scan.nextLine();

        System.out.println(input);
        System.out.println("test");
    }
}
