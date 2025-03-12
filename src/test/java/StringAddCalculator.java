import org.assertj.core.util.Strings;

public class StringAddCalculator {
    public static int splitAndSum(String text) {

        if(Strings.isNullOrEmpty(text)) {
            return 0;
        }

        if(text.startsWith("//") && text.contains("\n")) {
            int beginIndex = 2;
            int endIndex = text.indexOf("\n");
            String customSplitor = text.substring(beginIndex, endIndex);
            text = text.substring(endIndex+1);
//           log.debug("customDivision: " + customDivision);
//           log.debug("text = " + text);

            if(customSplitor != null) {
                text = text.replace(customSplitor, ",");
            }
        }

        String[] maybeNumbers = text.split(",|:");
        int answer = 0;
        for (String maybeNumber : maybeNumbers) {
            int number = Integer.parseInt(maybeNumber);
            if (number < 0) throw new RuntimeException();
            answer += number;
        }

        return answer;
    }
}
