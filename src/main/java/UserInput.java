import com.sun.org.apache.xerces.internal.xs.StringList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserInput {
    BufferedReader br;
    String line;
    String[] list;

    public UserInput() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        line = Console();

        validateUserInput(line);
        list = split(line);
    }

    public String Console() throws IOException {
        line = br.readLine();
        return line;
    }

    public String[] split(String userInput) {
        return userInput.trim().split(" ");
    }

    public void printList() {
        for (String s : list) {
            System.out.println(s);
        }
    }

    public void validateUserInput(String userInput) {
        isEmptyString(userInput);
    }

    public void isEmptyString(String userInput) {
        if (userInput.trim().equals("")) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }

    public void isOperationSymbol(String symbol) {
        String[] arr = {"+", "-", "*", "/"};
        List<String> symbols = new ArrayList<>(Arrays.asList(arr));
        if (!symbols.contains(symbol)) {
            throw new IllegalArgumentException("잘못된 연산기호입니다.");
        }
    }


}
