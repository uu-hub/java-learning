package io.zbc.learning.java.lambda;

/**
 * @author zmsoft
 * @version 1.0
 * @date 2021-03-27 11:21
 */

@FunctionalInterface
interface Foo {
//    public void sayHello();
    public int add(int x, int y);

    default int div(int x, int y) {
        System.out.println("*****hello java0222");
        return x/y;
    }

    default int div2(int x, int y) {
        System.out.println("*****hello java0222");
        return x/y;
    }

    public static int mv(int x,int y) {
        return x*y;
    }
}

/**
 *  Lambda Express
 *  1.拷贝小括号，写死右箭头，落地大括号
 *
 *  2.@FunctionalInterface
 *
 *  3.default
 *
 *  4.静态方法实现
 */
public class LambdaExpressDemo {

    public static void main(String[] args) {

//        Foo foo = new Foo() {
//            public void sayHello() {
//
//            }
//        };
//        foo.sayHello();
        /*Foo foo = () -> { System.out.println("******hello java0222 lambda Express");};
        foo.sayHello();*/
        Foo foo = ( x,  y) -> {
            System.out.println("****come in here");
            return x + y;
        };
        System.out.println(foo.add(3,5));

        System.out.println(foo.div(10,5));

        System.out.println(Foo.mv(3,5));


    }

}
