package common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserInput {

    public UserInput() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String userInput = bufferedReader.readLine();
        splitStr(userInput);
    }

    private List<String> splitStr(final String userInput) {
        return Arrays.stream(userInput.split(" ")).collect(Collectors.toList());
    }
}
