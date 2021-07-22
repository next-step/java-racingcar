package stringCalculator;

public class StringCalculator {

    public String calculate(String problem) {
        String[] problemArr = problem.split(" ");

        String a = problemArr[0];

        for (int i = 1; i < problemArr.length; i+=2) {
            if (problemArr[i].equals("+")) {
                a = sum(a, problemArr[i + 1]);
            }else if(problemArr[i].equals("-")){
                a = diff(a, problemArr[i + 1]);
            }else if(problemArr[i].equals("*")){
                a = mult(a, problemArr[i + 1]);
            }else if(problemArr[i].equals("/")){
                a = div(a, problemArr[i + 1]);
            }
        }

        return a;
    }


    public String sum(String a, String b) {
        int aInt = Integer.parseInt(a);
        int bInt = Integer.parseInt(b);
        return (aInt + bInt) + "";
    }

    public String diff(String a, String b) {
        int aInt = Integer.parseInt(a);
        int bInt = Integer.parseInt(b);
        return (aInt - bInt) + "";
    }

    public String mult(String a, String b) {
        int aInt = Integer.parseInt(a);
        int bInt = Integer.parseInt(b);
        return (aInt * bInt) + "";
    }

    public String div(String a, String b) {
        int aInt = Integer.parseInt(a);
        int bInt = Integer.parseInt(b);
        return (aInt / bInt) + "";
    }

}
