package racingcar.view

import racingcar.CustomHandlebarsTemplateEngineKt
import racingcar.RacingGameKt
import racingcar.RacingResultKt
import spark.ModelAndView

import spark.Spark.*

class WebMainKtKt {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

            // Kotlin 비교를 위해 포트번호 변경
            port(8082)
            staticFiles.location("/templates")

            get("/") { _, _ ->
                val model = hashMapOf<String, Any>()
                render(model, "index.html")
            }

            post("/name") { req, _ ->
                val names = req.queryParams("names").split(" ")
                val model = hashMapOf("names" to names)
                render(model, "game.html")
            }

            get("/result") { req, _ ->
                val names = req.queryParamsValues("names")
                val turn = Integer.parseInt(req.queryParams("turn"))

                val racingGame = RacingGameKt()
                racingGame.readyCars(names.joinToString(","))

                for (i in 0 until turn) {
                    racingGame.startRacing()
                }

                val racingResult = RacingResultKt(racingGame.getCars())
                val winners = racingResult.getWinners()
                val cars = racingGame.getCars()

                val model = hashMapOf(
                        "cars" to cars,
                        "winners" to winners
                )
                render(model, "result.html")
            }
        }

        private fun render(model: Map<String, Any>, templatePath: String): String =
                CustomHandlebarsTemplateEngineKt().render(ModelAndView(model, templatePath))
    }
}
