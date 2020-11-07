package race.view;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Util.println;

public class ResultView {
    private final static String BLOCK = "-";

    public static void printCarPosition(int position) {
        StringBuilder blocks = new StringBuilder();

        for (int i = 0; i < position; i++) {
            blocks.append(BLOCK);
        }

        println(blocks.toString());
    }

    public static void markFinishTurn() {
        println("");
    }
}
