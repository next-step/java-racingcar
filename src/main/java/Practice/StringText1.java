package Practice;

public class StringText1 {
    final String originText = "(1,2)";
    String changeText1 = originText.substring(1,4);
    String changeText2 = originText.replace("(", "").replace(")", "");
}
