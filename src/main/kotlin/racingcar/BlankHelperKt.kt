package racingcar

import com.github.jknack.handlebars.Helper
import com.github.jknack.handlebars.Options

class BlankHelperKt: Helper<Int> {
    override fun apply(context: Int?, options: Options?): Any {
        context ?: return ""

        val sb = StringBuilder()
        for (i in 0 until context) {
            sb.append(options?.fn(i + 1))
        }

        return sb.toString()
    }

    companion object {
        const val NAME = "blanks"
    }
}
