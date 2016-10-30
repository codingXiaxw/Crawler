package domain;

import spider.Spider;

import javax.swing.border.MatteBorder;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 创建bean对象，属性与我们需要的东西相配。
 * Created by codingBoy on 16/10/20.
 */
public class Zhihu
{
    public String title;
    public String titleDescription;
    public String zhihuUrl;
    public ArrayList<String> answers;



    public Zhihu(String url)
    {
        title="";
        titleDescription="";
        zhihuUrl="";
        answers=new ArrayList<>();

        if (getRealUrl(url))
        {
            System.out.println("正在抓取链接"+zhihuUrl);

            String content=Spider.sendGet(zhihuUrl);

            Pattern pattern;
            Matcher matcher;

            pattern=Pattern.compile("zh-question-title.+?<h2.+?>(.+?)</h2>");
            matcher=pattern.matcher(content);
            if (matcher.find()) {
                title = matcher.group(1);
            }

            pattern=Pattern.compile("zh-question-detail.+?<div.+?>(.*?)</div>");
            matcher=pattern.matcher(content);
            if (matcher.find()) {
                titleDescription=matcher.group(1);
            }

            pattern=Pattern.compile("/answer/content.+?<div.+?>(.*?)</div>");
            matcher=pattern.matcher(content);
            while (matcher.find())
            {
                answers.add(matcher.group(1));
            }

        }
    }

    @Override
    public String toString() {
        return "问题为:"+title+"\n问题描述为:"+titleDescription+
                "\n地址为:"+zhihuUrl+"\n回答的内容为:"+answers+"\n";
    }


    boolean getRealUrl(String url)
    {
        String regex="question/(.+?)/";

        Pattern pattern=Pattern.compile(regex);
        Matcher matcher=pattern.matcher(url);

        while (matcher.find())
        {
            zhihuUrl="http://www.zhihu.com/question/"+matcher.group(1);

            return true;
        }
        return false;
    }

}
