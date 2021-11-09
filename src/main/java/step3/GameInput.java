package step3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GameInput {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static int readInt() throws IOException {
        return Integer.parseInt(br.readLine());
    }
}
