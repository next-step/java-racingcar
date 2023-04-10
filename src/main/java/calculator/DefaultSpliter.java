package calculator;

public class DefaultSpliter implements Spliter{
    @Override
    public String[] split(String text) {
        String[] split = text.split("[,:]");
        return StringUtils.isInteger(split[0]) ? split : new String[0];
    }

    @Override
    public boolean isSupport(String text) {
        return text.contains(",") || text.contains(":") || StringUtils.isInteger(text);
    }
}
