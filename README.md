# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 요구사항 분석
### step1 : 문자열 계산기
- 사용자의 입력을 받을 수 있습니다.
- 계산 결과를 출력할 수 있습니다.
- 입력 값이 유효하지 않은 경우 적절한 예외를 던집니다.
- 입력 값은 자연수와 사칙연산으로 이루어져있다고 가정합니다.

### step2 : 자동차 경주
- 사용자의 입력을 받을 수 있습니다.
    - 적절한 안내문을 출력합니다.  
    - 2개의 정수를 입력 받습니다(자동차의 대수, 시도 횟수).
    - 정수가 아닌 입력이 주어지는 경우는 고려하지 않습니다. 
    - 자동차의 대수나, 시도 횟수가 0보다 작은 경우 예외를 던집니다. 
- 게임 결과를 출력할 수 있습니다. 
    - '실행 결과' 이후 각 시도 횟수마다 자동차들의 위치를 출력합니다. 
- 각 시도마다 조건에 따라서 자동차를 이동시킵니다. 
    - 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우입니다.