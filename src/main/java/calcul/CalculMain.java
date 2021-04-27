package calcul;

import java.util.Scanner;

public class CalculMain {

    public static void main(String[] args) throws IllegalAccessException {

        Calcul calcul = new Calcul();

        Scanner scanner = new Scanner(System.in);

        System.out.print("input : ");
        String input = scanner.nextLine();
        String[] split = input.split(" ");

        int result = Integer.parseInt(split[0]);

        for (int i = 0; i < split.length; i++) {

            if (split[i].equals("+")) {

                result = calcul.add(result, Integer.parseInt(split[i + 1]));
            } else if (split[i].equals("-")) {

                result = calcul.sub(result, Integer.parseInt(split[i + 1]));
            } else if (split[i].equals("*")) {

                result = calcul.multi(result, Integer.parseInt(split[i + 1]));
            } else if (split[i].equals("/")) {

                result = calcul.division(result, Integer.parseInt(split[i + 1]));
            }
        }

        calcul.nullCheck(input);
        calcul.operCheck(input);

        System.out.println("결과값 : " + result);
    }
}
