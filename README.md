# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 요구사항 분석

### 경주 조건
1. 자동차 N대 존재
2. 각 자동차는 랜덤값에 따라 전진 or 정지
   - 전진 조건 : 4 이상
   - 정지 조건 : 3 이하
3. 사용자는 몇 번 이동할지 입력 가능

### 자동차 이름
1. 쉼표로 구분
2. 5자 이하
   - 5자를 초과하는 이름이 입력됐을 경우 IllegalArgumentException() 발생
3. 중복 금지
   - IllegalArgumentException() 발생
4. 빈 문자열이나 공백 금지
   - IllegalArgumentException() 발생
