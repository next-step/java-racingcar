import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputText {

    private static final String DEFAULT_SEPARATORS = ",|:";
    private static final String CUSTOM_SEPARATOR_FINDERS = "//(.)\n(.*)";

    private final String text;

    public InputText(String text) {
        this.text = text;
    }

    public static InputText from(String text){
        return new InputText(text);
    }

    public boolean isBlank() {
        return this.text == null || this.text.isEmpty();
    }

    public String[] split(){
        Matcher m = Pattern.compile(CUSTOM_SEPARATOR_FINDERS).matcher(this.text);
        if(m.find()){
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return this.text.split(DEFAULT_SEPARATORS);
    }
}
