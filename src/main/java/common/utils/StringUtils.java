package common.utils;

public class StringUtils {
    public static boolean isEmpty(String args) {
        return args==null || args.length()==0;
    }
    public static boolean isBlank(String args) {
        return args==null || args.trim().length()==0;
    }
}