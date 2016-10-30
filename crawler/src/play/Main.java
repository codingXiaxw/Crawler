package play;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 简单的例子，抓取网页源代码
 * Created by codingBoy on 16/10/20.
 */
public class Main
{
    public  static String sendGet(String url)
    {

        BufferedReader reader=null;

        String result="";

        try {
            URL realUrl = new URL(url);
            URLConnection connection = realUrl.openConnection();

            reader=new BufferedReader(new InputStreamReader(connection.getInputStream(),"utf-8"));

            String line;
            while ((line = reader.readLine()) != null) {
                result+=line;
            }

            return result;
        }catch (Exception e)
        {
            throw  new RuntimeException("get方法请求错误"+e);
        }finally {
            try {
                if (reader != null) reader.close();
            }catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }

    public static String regexString(String targetStr, String patternStr)
    {
        // 定义一个样式模板，此中使用正则表达式，括号中是要抓的内容
        // 相当于埋好了陷阱匹配的地方就会掉下去
        Pattern pattern=Pattern.compile(patternStr);

        System.out.println(pattern.pattern());
        // 定义一个matcher用来做匹配
        Matcher matcher=pattern.matcher(targetStr);



        if (matcher.find())
        {
            return matcher.group(1);
        }

        return "没有找到相匹配的字符";
    }

    public static void main(String[] args)
    {
        String url="http://www.baidu.com";
        String result=sendGet(url);

        String imgSrc=regexString(result,"src=(.+png\\b)");



        System.out.println(result);
        System.out.println(imgSrc);
    }
}
