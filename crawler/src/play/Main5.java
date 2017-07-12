package play;

import spider.Spider;

/**
 * Created by codingBoy on 16/10/24.
 */
public class Main5
{
    public static void main(String[] args)
    {
        Spider spider=new Spider();
        String result=spider.sendGet("https://www.zhihu.com/explore/recommendations");
        System.out.println(result);
    }
}
