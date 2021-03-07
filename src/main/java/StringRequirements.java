import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringRequirements {
    public List<Integer> splitIntegers(String integersWithCommas){
        return Arrays.stream(integersWithCommas.split(","))
                .sequential()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public String removeBrackets(String integersWithBrackets){
        return integersWithBrackets.substring(1,integersWithBrackets.length()-1);
    }

    public char getCharAtIdx(String string, int idx){
        if(idx<0 || idx>=string.length()){
            throw new StringIndexOutOfBoundsException();
        }
        return string.charAt(idx);
    }
}
