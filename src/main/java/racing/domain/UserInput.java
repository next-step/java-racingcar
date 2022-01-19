package racing.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class UserInput {
    public static void getCarNames() {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        List<String> nameList = splitStringByComma(input);
    }

    public static List<String> splitStringByComma(String input) {
        List<String> nameList = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(input, ",");

        while(st.hasMoreTokens()) {
            nameList.add(st.nextToken().trim());
        }

        return nameList;
    }
}
