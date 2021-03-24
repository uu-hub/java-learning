package io.zbc.learning.java;

import java.util.regex.Pattern;

public class RegexLearning {
    public static void main(String[] args) {
        StringBuffer buf = new StringBuffer("head<TotalAmountExclud>361.21</TotalAmountExclud>end");
        // 作为参数传递的buf，不会因为在方法内部重新赋值而被改变
        testStringBuffer(buf);
        System.out.println("不会被修改的buf：" + buf);
    }

    private static void testStringBuffer(StringBuffer buf) {
        String result = replaceXmlTab(buf.toString(), "TotalAmountExclud", "12.34");
        System.out.println("处理结果：" + result);
        buf = new StringBuffer(result);
        System.out.println("被修改的buf：" + buf);
    }

    private static String replaceXmlTab(String xml, String tab, String target) {
        StringBuffer regex = new StringBuffer();
        regex.append("(<");
        regex.append(tab);
        regex.append(">).*(</");
        regex.append(tab);
        regex.append(">)");
        return xml.replaceAll(regex.toString(), "$1" + target + "$2");
    }
}
