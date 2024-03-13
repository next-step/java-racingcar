package step1;

public class CommaStringSplitter {
    static String separator = ",";
    public static String[] split(String input){
        String sanitizedInput = input;

        boolean isParenthesis = input.startsWith("(") && input.endsWith(")");
        if(isParenthesis){
            sanitizedInput = input.substring(1, input.length()-1);
        }
        String[] output = sanitizedInput.split(CommaStringSplitter.separator);

        return output;
    }
}
