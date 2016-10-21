## 用Java语言实现的一个简易网络爬虫  

## 目标
爬取知乎网的推荐页面的所有问题、问题链接、问题链以及关于对问题的回答，然后将它们打印在控制台。后序进阶会将爬去结果保存到数据库中，详细教程见我博客[codingXiaxw' blog](http://codingxiaxw.cn) 。博客地址为:http://codingxiaxw.cn  

博客用了以下四篇文章来介绍，目前完成了前三篇，所以附上经过前三篇文章的教程后得到的爬取效果: 

**博客一览表:**  

<img src="http://od2xrf8gr.bkt.clouddn.com/%E4%B8%80%E8%A7%88%E8%A1%A8.png" width="80%" height="80%">


## 效果图

<img src="http://od2xrf8gr.bkt.clouddn.com/%E7%88%AC%E5%8F%96%E7%BB%93%E6%9E%9C.png" width="80%" height="80%">


## 搭建环境
目前只用到IntelliJ IDEA + chrome  后序完成第四篇文章介绍的知识时，会用到数据库MySQL

## 项目介绍
其中只有三个.java文件是需要的，SpaceMessage.java、Demo.java、Main.java、Main2.java、Main3.Java这四个文件是我玩玩写的demo，只需看Spider.java、Main4.java、Zhihu.java这三个文件。  

- Spider.java:1.sendGet()方法获取网页源码。2.regexString()方法用于返回和网页源码匹配到的结果(即我们需要的内容)。
- Zhihu.java:封装我们需要的内容。
- Main4.java:传入需要爬取页面的url。



