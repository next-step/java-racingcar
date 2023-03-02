package calculator;

public class Calculator {


    public int parser(String text) {
        if (text == null) {
            throw new IllegalArgumentException("text is null");
        }

        if (text.isBlank()) {
            throw new IllegalArgumentException("text is blank");
        }

        String[] values = text.split(" ");

        System.out.println(values);


        return 0;

    }

}
