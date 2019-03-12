package domain;

import java.io.InputStream;
import java.util.Scanner;

public class ConsoleInput implements Input{
    private Scanner scanner;

    public ConsoleInput(InputStream in){
        this.scanner = new Scanner(in);
    }

    @Override
    public int nextInt() {
        return scanner.nextInt();
    }
}
