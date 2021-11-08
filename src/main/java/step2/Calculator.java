package step2;

public class Calculator {

    public int calculate(String s) {
        if (s == null || s.trim().length() == 0) {
            throw new IllegalArgumentException();
        }

        String[] info = s.split(" ");

        int ans = Integer.parseInt(info[0]);
        for (int i = 1; i < info.length; i += 2) {
            int next = Integer.parseInt(info[i + 1]);

            if (info[i].equals("+")) {
                ans = ans + next;
            } else if (info[i].equals("-")) {
                ans = ans - next;
            } else if (info[i].equals("*")) {
                ans = ans * next;
            } else if (info[i].equals("/")) {
                ans = ans / next;
            }
        }

        return ans;
    }
}
