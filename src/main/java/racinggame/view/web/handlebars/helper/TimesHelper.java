package racinggame.view.web.handlebars.helper;

import com.github.jknack.handlebars.Helper;
import com.github.jknack.handlebars.Options;

import java.io.IOException;

/**
 * Created by hspark on 06/11/2018.
 */
public class TimesHelper implements Helper<Integer> {
	public static final String HELPER_NAME = "times";
	@Override
	public Object apply(Integer context, Options options) throws IOException {
		if (context == null) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < context; i++) {
			sb.append(options.fn(i + 1));
		}
		return sb.toString();
	}
}
