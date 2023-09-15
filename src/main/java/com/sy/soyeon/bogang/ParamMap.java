package com.sy.soyeon.bogang;

import java.util.HashMap;

/*
    - 여기 Map은 HashMap의 기능을 갖되 반드시 key가 String이어야 함
        ㄴ HashMap의 기능 - 상속
    - String getString(String key) 신규 추가
    - String getInt(String key) 신규 추가
    - T get(String key, 파라미터타입) 동적으로 반환타입을 갖는 함수 신규가
    - 생성자 없이 init() 함수를 이용하여 객체생성 할 수 있도록 구성
        ㄴ 생성자로 못 만들도록 -> 외부접근을 막겠다 -> 접근제한자 private
 */
public class ParamMap extends HashMap<String, Object> {

    private ParamMap() {}

    public static ParamMap init() {
        return new ParamMap();
    }

    public String getString(String key) {
        Object object = this.get(key);  // HashMap이 가지고 있는 함수
        if(object == null) {    // String.valueOf의 값이 null일 때 'null'로 찍혀서 그걸 막이 위해
            return null;
        } else {
            return String.valueOf(object);
        }
    }

    public Integer getInt(String key) {
        Object object = this.get(key);
        if(object == null) {
            return null;   // int에는 null이 없고, Integer에는 Null 있음.
        } else {
            return Integer.parseInt(String.valueOf(object));
        }
    }

    // 타입 정의
    public <T> T get(String key, Class<T> clazz) {
        Object object = this.get(key);
        return (T) object;
    }

    public static void main(String[] args) {

    }
}
