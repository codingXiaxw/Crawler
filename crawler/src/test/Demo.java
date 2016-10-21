package test;

import java.awt.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by codingBoy on 16/10/20.
 */
public class Demo
{
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher("22bb23");

        System.out.println(pattern.pattern());
        System.out.println(matcher.pattern());

        Pattern pattern1 = Pattern.compile("href=\"(.+?)\"");
        Matcher matcher1 = pattern1.matcher("＜a href=\"index.html\"＞我的主页＜/a＞");

        if (matcher1.find()) {
            // 打印出结果
            System.out.println(matcher1.group(1));
        }

        Pattern p=Pattern.compile("\\d+");
        Matcher m=p.matcher("2223bb");
        m.find();

        System.out.println(m.start());
        System.out.println(m.end());
        System.out.println(m.group());
    }
}
