package game;

import java.io.PrintWriter;

public class OutputView {
    private static PrintWriter writer;

    static {
        writer = new PrintWriter(System.out);
    }

    public static void printData(int movingCount) {
        for (int i = 0; i < movingCount; i++) {
            System.out.print("-");
        }
    }
}
