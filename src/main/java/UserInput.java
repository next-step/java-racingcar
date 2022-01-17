import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class UserInput {

    BufferedReader br;
    String line;
    List<String> list;

    public UserInput() {
        br = new BufferedReader(new InputStreamReader(System.in));
        line = "";
        list = new ArrayList<>();
    }

    public String Console() throws IOException {
        line = br.readLine();
        return line;
    }

    public void split(String userInput) {
        String[] splits = userInput.split(" ");

        for (int i = 0; i < splits.length; i++) {
            list.add(splits[i]);
        }
    }

    public void validateUserInput(String userInput) {
        if (userInput.trim().equals("")) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }
}
