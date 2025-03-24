package utils.strategy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomDelimiterSplitter implements Splitter {
    public final static Pattern pattern = Pattern.compile("//(.)\n(.*)");

    @Override
    public boolean isSupport(String input) {
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    @Override
    public String[] split(String input) {
        Matcher matcher = pattern.matcher(input);

        if(!matcher.find()){
            throw new RuntimeException("패턴에 매칭되지 않습니다.");
        }

        String customDelimiter = Pattern.quote(matcher.group(1));
        String numbersPart = matcher.group(2);
        String delimiter = customDelimiter + "|" +  Splitter.defaultDelimiter;

        return numbersPart.split(delimiter);
    }
}
