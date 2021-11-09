package step3;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class GameOutput {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static void println(String message) throws IOException {
        bw.write(message);
        bw.write('\n');
        bw.flush();
    }

}
