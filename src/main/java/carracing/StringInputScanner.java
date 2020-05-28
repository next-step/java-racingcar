package carracing;

import java.util.Scanner;

public class StringInputScanner {

    private String[] names;

    private void getInputStream() {
        Scanner scanner = new Scanner(System.in);
        this.names  = scanner.next().split(",");
    }

    public String[] getNames() {
        getInputStream();

        return names;
    }
}
