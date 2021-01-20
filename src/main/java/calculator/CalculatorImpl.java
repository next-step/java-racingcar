package calculator;

import java.util.*;

public class CalculatorImpl implements Calculator{
    private Checker checker = new CheckerImpl();

    @Override
    public void printInputInformation() {
        System.out.print("Input : ");
    }

    @Override
    public List<String> input() {
        Scanner scanner = new Scanner(System.in);
        String inputText = scanner.nextLine().replace(" ",""); //1 + 1 + 1
        checker.checkBlank(inputText);
        return convertResults(inputText);
    }

    private List<String> convertResults(String inputText){
        List<String> results = new ArrayList<>();
        StringBuilder string = new StringBuilder();
        for (char word : inputText.toCharArray()) {
            if(word == ' '){
                continue;
            }
            else if(word == '+' || word =='-' || word == '*' || word == '/'){
                results.add(string.toString());
                results.add(String.valueOf(word));
                string = new StringBuilder();
            }else if(Character.isDigit(word)){
                string.append(word);
            }else {
                checker.throwNotCorrectSign();
            }
        }
        results.add(string.toString());
        return results;
    }

    @Override
    public int calculate(List<String> input) {
        Queue<String> queue = new LinkedList<>(input);
        int result = pollNumberBy(queue);
        while (!queue.isEmpty()) {
            char sign = pollSignBy(queue);
            int target = pollNumberBy(queue);
            result = calculate(result, target, sign);
        }

        System.out.println(result);
        return result;
    }

    private char pollSignBy(Queue<String> queue) {
        String signString = queue.poll();
        if(!signString.matches("[+-/*]")){
//            throw new IllegalFormatException("You should input sign +-/*");
        }

        return signString.charAt(0);
    }

    private int pollNumberBy(Queue<String> queue){
        String numberString = queue.poll();

//        if(!numberString.matches("[0-9]")){
//            throw new NumberFormatException("You should input only number character.");
//        }

        return Integer.parseInt(numberString);
    }

    private int calculate(int a, int b, char sign) {
        switch (sign) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return a / b;
        }

        return 0;
    }
}
