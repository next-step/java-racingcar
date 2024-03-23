# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

step 3
* feature/race-unit-test
  * generate unit test of requirements
* feature/car-racing
  * generate Car as object
  * complete the car racing application
  * refactored and modified the unit test code
* refactor/step2
  * put checkInputAvailable() inside the main logic (b/c never used except test code)
  * refactored codes
  * put Scanner SCAN as a Constant
  * modified the Boolean method
  * modified public methods to private should not be public
  * modified the test codes as well with using reflection
* refactor/racing
  * modified public methods to private should not be public (**modified like the step2 modified**)
  * modified the test codes as well with using reflection
  * delete the useless code in step2 test code
* refactor/optimize-imports
  * unused imports removed
* refactor/remove-reflection
  * ensure not to test private method -> do not test with reflection
* refactor/class-segregation
  * refactored code w/ Class, Interface segregation'

step 4
* refactor/step-3
  * refactored based on the feedback from pull request
  * generate ViewPrinter
  * set position as Integer to calculate
* feature/mod-racing-application-with-step4
  * modified racing application with step4 requirements
* refactor/step4
  * refactored with FirstClass Collection
  * refactored with using Stream()
  * Test Codes are refactored