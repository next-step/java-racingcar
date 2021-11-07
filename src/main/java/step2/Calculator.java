package step2;

public class Calculator {

    public static int execute(String str) {
        checkBlankOrNull(str);
        String[] s = str.split(" ");
        if (s.length % 2 == 0) throw new IllegalArgumentException(str + "은 입력될 수 없습니다");

        int ans = Integer.parseInt(s[0]);
        for (int i = 0; i < s.length - 2; i += 2) {
            ans = Operation.from(s[i + 1]).apply(ans, Integer.parseInt(s[i + 2]));
        }
        return ans;
    }

    private static void checkBlankOrNull(String str) {
        if (str == null || str.equals("")) {
            throw new IllegalArgumentException(str + "은 입력될 수 없습니다");
        }

    }


}
