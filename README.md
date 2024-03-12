# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)


## 3단계 구현 기능 목록
- 사용자가 몇대의 자동차로 이동할 것인지 입력받는 기능
- 사용자가 몇번의 기회로 이동할 것인지 입력받는 기능
- 전진하는 조건 기능
    - 0~9 사이의 랜덤값을 구하는 기능
    - 랜덤값이 4이상이면 전진하는 기능
- 자동차 상태를 출력하는 기능

### 에러 체크
- 입력에 대한 에러처리
    - 정수형이 아닌경우 익셉션을 캐치하여 로그를 남긴다.
- 최대개수 제한
    - 일반적으로 100000이 넘어갈 경우에 시간복잡도를 생각해야 하기 때문에 입력크기를 10000으로 제한한다.
