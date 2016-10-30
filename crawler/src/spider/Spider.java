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



        Pattern urlPattern=Pattern.compile("<h2>.+?question_link.+?href=\"(.+?)\".+?</h2>");//匹配url地址
        Matcher urlMatcher=urlPattern.matcher(targetStr);

        while (urlMatcher.find())
        {
            Zhihu zhihu=new Zhihu("http://www.zhihu.com"+urlMatcher.group(1));


            lists.add(zhihu);
        }
        return lists;
    }
}
