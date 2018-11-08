package racingcar

import spark.template.handlebars.HandlebarsTemplateEngine

class CustomHandlebarsTemplateEngineKt : HandlebarsTemplateEngine() {
    init {
        this.handlebars.registerHelper(BlankHelper.NAME, BlankHelperKt())
    }
}
