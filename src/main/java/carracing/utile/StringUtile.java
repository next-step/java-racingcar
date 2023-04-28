package carracing.utile;

public class StringUtile {
    public static String[] split(String text) {
        String[] arrText = text.split(",");
        return arrText;
    }

    public static String trim(String text) {
        return text.trim();
    }
}
