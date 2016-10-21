package domain;

import spider.Spider;

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



    public Zhihu()
    {
        title="";
        titleDescription="";
        zhihuUrl="";
        answers=new ArrayList<>();


    }

    @Override
    public String toString() {
        return "问题为:"+title+"\n问题描述为:"+titleDescription+
                "\n地址为:"+zhihuUrl+"\n回答的内容为:"+answers+"\n";
    }



}
