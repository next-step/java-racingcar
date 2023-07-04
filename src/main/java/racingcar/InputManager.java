package racingcar;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class InputManager implements Closeable {
    private final BufferedReader bufferedReader;

    public InputManager() {
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public int readRound() throws IOException {
        return Integer.parseInt(bufferedReader.readLine());
    }

    public List<String> readCarNames() throws IOException {
        return List.of(bufferedReader.readLine().split(","));
    }

    @Override
    public void close() throws IOException {
        bufferedReader.close();
    }
}
