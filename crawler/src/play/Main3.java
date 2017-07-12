package play;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 抓取知乎上多条问题和问题链接
 * Created by codingBoy on 16/10/20.
 */
public class Main3
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

    public static ArrayList<String> regexString(String targetStr, String patternStr)
    {
        ArrayList<String> lists=new ArrayList<>();
        // 定义一个样式模板，此中使用正则表达式，括号中是要抓的内容
        // 相当于埋好了陷阱匹配的地方就会掉下去
        Pattern pattern=Pattern.compile(patternStr);

        // 定义一个matcher用来做匹配
        Matcher matcher=pattern.matcher(targetStr);



        while (matcher.find())
        {
            String result=matcher.group(1);
            lists.add(result);

        }
        return lists;

    }

    public static void main(String[] args)
    {
        ArrayList<String> list;

        String url="https://www.zhihu.com/explore/recommendations";
        String result=sendGet(url);

        list=regexString(result,"post-link.+?>(.+?)<");
        System.out.println(list);




    }
}
