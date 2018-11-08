package racingcar

import spark.template.handlebars.HandlebarsTemplateEngine

class CustomHandlebarsTemplateEngineKt : HandlebarsTemplateEngine() {
    init {
        this.handlebars.registerHelper(BlankHelperKt.NAME, BlankHelperKt())
    }
}
