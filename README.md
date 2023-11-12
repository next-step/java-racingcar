# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

------
# Step 3
## 기능 요구사항
### TODO
* [ ] 정상적인 입력인지 확인하기
* [ ] random 값 생성하기
* [ ] 전진하기 (자동차 위치 업데이트)
* [ ] 자동차 상태 출력하기

### DONE
* [X] 자동차 갯수와 이동 횟수 입력받기

## 프로그래밍 요구사항
- 모든 로직에 단위 테스트 구현
- 핵심 로직을 구현하는 코드와 UI를 담당하는 로직 구분
- UI 로직은 InputView, ResultView와 같은 클래스를 추가해 분리
- 자바 코드 컨벤션을 지키며 프로그래밍
  - Mac : ⌥ (Option) + ⌘ (Command) + L
- else 예약어 사용 금지