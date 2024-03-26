import java.util.List;

/**
 * @author jeongheekim
 * @date 3/27/24
 */
public class FormattingUtil {
    private FormattingUtil() {}

    public static String formattingResult(List<String> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            sb.append(list.get(i));
            if (i < size - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }
}
