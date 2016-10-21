package spider;

import domain.Zhihu;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 1.获取网页源码
 * 2.将与正则表达式匹配的字符串封装到Zhihu对象中，然后将Zhihu对象添加至泛型ArrayList中。
 * Created by codingBoy on 16/10/20.
 */
public class Spider
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

    public static ArrayList<Zhihu> regexString(String targetStr)
    {
        ArrayList<Zhihu> lists=new ArrayList<>();


        // 定义一个样式模板，此中使用正则表达式，括号中是要抓的内容
        // 相当于埋好了陷阱匹配的地方就会掉下去
        Pattern titlePattern=Pattern.compile("question_link.+?>(.+?)<");//匹配标题
        Matcher titleMatcher=titlePattern.matcher(targetStr); // 定义一个matcher用来做匹配

        Pattern urlPattern=Pattern.compile("<h2>.+?question_link.+?href=\"(.+?)\".+?</h2>");//匹配url地址
        Matcher urlMatcher=urlPattern.matcher(targetStr);

        while (titleMatcher.find() && urlMatcher.find())
        {
            Zhihu zhihu=new Zhihu();

            String title=titleMatcher.group(1);
            String address="http://www.zhihu.com"+urlMatcher.group(1);

            zhihu.title=title;
            zhihu.zhihuUrl=address;

            lists.add(zhihu);
        }
        return lists;
    }
}
