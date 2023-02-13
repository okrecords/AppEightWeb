# AppEightWeb
## Firebase Authentication - 이메일/비밀번호 로그인
- 사용자가 자신의 이메일 주소와 비밀번호를 사용해 로그인할 수 있도록 허용
- 이메일 주소 확인, 비밀번호 복구, 이메일 주소 변경 제공
- Firebase Authentication Sign-in method에서 이메일/비밀번호를 선택한 후 [Firebase Documentation](https://firebase.google.com/docs/auth/android/password-auth?hl=ko)을 참고하여 코드 작성

AppEightWeb에서 [Firebase 이메일/비밀번호 로그인](https://github.com/okrecords/AppEightWeb/blob/master/app/src/main/java/com/okre/appeightweb/JoinActivity.kt)
<br/><br/><br/>

## ->(separator)
- separator라는 명칭은 검색의 편의를 위해 임시로 붙인 명칭  
- [공식문서](https://kotlinlang.org/docs/keyword-reference.html#operators-and-special-symbols) 설명
  - separates the parameters and body of a lambda expression. (람다식의 파라미터와 바디를 구분합니다.)
  - separates the parameters and return type declaration in a function type. (함수 형식에서 파라미터와 리턴 타입을 구분합니다.)
  - separates the condition and body of a when expression branch. (when에서 조건과 결과를 구분합니다.)

AppEightWeb에서 [->(separator)](https://github.com/okrecords/AppEightWeb/blob/f85a888ae16c84b050f845467bc4145a7fda41ba/app/src/main/java/com/okre/appeightweb/RVAdapter.kt#L27)
<br/><br/><br/>

## Drawable - shape
- 일반 도형 모양을 직접 그리는(Shape Drawable) xml
- [공식문서](https://developer.android.com/guide/topics/resources/drawable-resource?hl=ko#Shape)

AppEightWeb에서 [drawable shape](https://github.com/okrecords/AppEightWeb/blob/master/app/src/main/res/drawable-v24/radius.xml)
<br/><br/><br/>

## WebView
- 웹 브라우저를 뷰(View)형태로 앱에 표시
- AndroidManifest.xml 인터넷 허용 권한 추가
```
<uses-permission android:name=”android.permission.INTERNET”/>
<application android:hardwareAccelerated="true"> <!--웹을 렌더링하는 과정에서 속도, 성능을 높일 수 있도록 하드웨어 가속을 원할 경우 true-->
```
AppEightWeb에서 [WebView 권한 추가](https://github.com/okrecords/AppEightWeb/blob/master/app/src/main/AndroidManifest.xml)

- WebView url
```
webView.loadUrl(url주소)
```
AppEightWeb에서 [WebView](https://github.com/okrecords/AppEightWeb/blob/f85a888ae16c84b050f845467bc4145a7fda41ba/app/src/main/java/com/okre/appeightweb/ViewActivity.kt#L27)
