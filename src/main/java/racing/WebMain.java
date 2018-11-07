package racing;

import racing.domain.RacingGame;
import racing.dto.RacingGameCreateRequest;
import racing.dto.RacingGameStatus;
import racing.ui.CustomHandlebarsTemplateEngine;
import racing.util.RacingCarStringUtils;
import spark.ModelAndView;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

/**
 * # 기능 요구사항
 * 콘솔 UI 대신 웹 UI를 적용한다.
 * 웹 UI를 적용할 HTML 템플릿은 fork한 저장소의 src/main/resources 디렉토리의 templates 디렉토리에 있다.
 * 메인 페이지는 index.html 페이지에서 시작한다.
 * 웹 UI 구현할 때 중간 단계를 출력하기 힘들면 최종 결과만 화면에 출력한다.
 * <p>
 * # 프로그래밍 요구사항
 * 웹 UI를 적용할 때 기존 코드를 수정하지 않아야 한다.
 * 핵심 비지니스 로직을 가지는 객체를 domain 패키지, UI 관련한 객체를 view 패키지에 구현한다.
 * 패키지 간의 의존관계는 view 패키지의 객체가 domain 패키지 객체에 의존할 수 있지만, domain 패키지의 객체는 view 패키지 객체에 의존하지 않도록 구현한다.
 * 콘솔 UI를 실행하는 main() 메소드는 ConsoleMain, 웹 UI를 실행하는 main() 메소드는 WebMain과 같이 분리한다.
 * domain 패키지 객체는 ConsoleMain과 WebMain에 따라 다른 부분이 존재하지 않아야 한다.
 */
public class WebMain {
    public static void main(String[] args) {
        port(8080);

        get("/", (req, res) -> render("index.html"));

        post("/name", (req, res) -> {
            String rawNames = req.queryParams("names");
            List<String> names = RacingCarStringUtils.splitNames(rawNames, " ");

            Map<String, Object> modelMap = new HashMap<>();
            modelMap.put("names", names);

            return render(modelMap, "game.html");
        });

        get("/result", (req, res) -> {
            // 카운트를 가져온다
            String rawCount = req.queryParams("turn");
            Integer count = Integer.valueOf(rawCount);

            // 이름을 가져온다.
            String[] rawNames = req.queryParamsValues("name");
            List<String> names = Arrays.asList(rawNames);

            // racingGames를 만들고
            RacingGameCreateRequest request = new RacingGameCreateRequest(names, count);
            RacingGame racingGame = new RacingGame(request);

            // racing을 진행
            RacingGameStatus racingGameStatus = null;
            while (racingGame.isRacingAvailable()) {
                racingGameStatus = racingGame.race();
            }

            // 결과를 modelMap에 담는다.
            Map<String, Object> modelMap = new HashMap<>();
            modelMap.put("result", racingGameStatus);

            // 반환
            return render(modelMap, "result.html");
        });
    }

    public static String render(Map<String, Object> model, String templatePath) {
        return new CustomHandlebarsTemplateEngine()
                .render(new ModelAndView(model, templatePath));
    }

    public static String render(String templatePath) {
        return render(null, templatePath);

    }
}
