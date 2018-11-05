package racinggame.view.handlebars;

import racinggame.view.handlebars.helper.TimesHelper;
import spark.template.handlebars.HandlebarsTemplateEngine;

/**
 * Created by hspark on 05/11/2018.
 */
public class CustomHandlebarsTemplateEngine extends HandlebarsTemplateEngine {
	public CustomHandlebarsTemplateEngine() {
		super();
		this.handlebars.registerHelper(TimesHelper.HELPER_NAME, new TimesHelper());
	}
}
