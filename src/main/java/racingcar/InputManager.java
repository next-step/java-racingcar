package racingcar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class InputManager {
    public static List<String> readCarNames() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            return List.of(br.readLine().split(","));
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    public static int readRound() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            return Integer.parseInt(br.readLine());
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}
