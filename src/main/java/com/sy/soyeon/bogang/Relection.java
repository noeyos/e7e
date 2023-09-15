package com.sy.soyeon.bogang;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/*
    Reflection
    - String -> 특정 Class 타입 객체 생성 -> Class<T>
    - String -> Class<T> -> 객체 생성
    - String -> Class<T>, Constructor -> 객체 생성
    - String -> Class<T> -> Field -> 속성접근 및 객체의 속성 조회
    - String -> Class<T> -> Method -> 함수접근 및 함수호출

 */
public class Relection {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        // String -> 특정 Class 타입 객체 생성 -> Class<T>
        // 클래스명 : com.sy.soyeon.bogang.Relection (정식명칭)
        //          Relection(심플네임)

//        클래스 타입의 객체가 있어야 함수, 속성 이용 가능
//        Class.forName() 가장 기본적
        Class<?> forName = Class.forName("com.sy.soyeon.bogang.MemberVO");

        // String -> Class<T> -> 객체 생성
        {
            Object newInstance = forName.newInstance();
            System.out.println(newInstance);
        }

        // String -> Class<T> -> Constructor -> 객체 생성
        {
            // public MemberVO() {}
            Constructor<?> const1 = forName.getDeclaredConstructor(); // public MemberVO() {}
            Object newInstance = const1.newInstance(); // new MemberVO()
            System.out.println(newInstance);

            // public MemberVO(String ... , ... ,... )
            Constructor<?> const2 = forName.getDeclaredConstructor(String.class, int.class, String.class);
            Object newInstance2 = const2.newInstance("이소연", 26, "F");
            System.out.println(newInstance2);
        }

        // String -> Class<T> -> Field -> 속성접근 및 객체의 속성조회
        {
            Constructor<?> const2 = forName.getDeclaredConstructor(String.class, int.class, String.class);
            Object newInstance2 = const2.newInstance("이소연", 26, "F");

            // List 순서 보장, Set 순서보장 X
            // List 중복 허용, Set 중복허용 X

            // name, age, gender
            Field field = forName.getDeclaredField("name"); // private String name;
            // name -> 이소연 -> MemberVO vo -> vo.name
            field.setAccessible(true);
            Object object = field.get(newInstance2); // [vo].name
            System.out.println(object);


            field.set(newInstance2, "햄스터"); // 필드명 변경
            field.setAccessible(false);
            System.out.println(newInstance2);

        }

        // String -> Class<T> -> Method -> 함수접근 및 함수 호출
        {
            Constructor<?> const2 = forName.getDeclaredConstructor(String.class, int.class, String.class);
            Object newInstance2 = const2.newInstance("이소연", 26, "F");

            // vo.setName("마루는강쥐")
            // forName.getDeclaredMethods("메소드명", 파라미터타입들);
            Method method = forName.getDeclaredMethod("setName", String.class);
            // method.invoke(method, "args")
            method.invoke(newInstance2, "마루는강쥐");
            System.out.println(newInstance2);
        }
    }
}
