# eshop
![小男孩](https://www.aboy.site/wp-content/uploads/2018/05/ABoy.png)
> 我们课堂上的eshop购物网站的制作，这里就给大家共享一下。当然这里的SQL脚本是张老师书写，如果以后有需要的话还会修改SQL脚本的

----
* [如何使用](#howtouse)
    + [克隆代码前的准备](#onready)
    + [克隆命令的使用](#usecloe)
* [使用中的一点声明](#stentcebeforuse)

#
> ### <h2 id="howtouse">如何使用</h2>
- #### 克隆代码前的准备
    - 安装git

    ![git](https://git-scm.com/favicon.ico)
    <p>到度娘中搜索git,咯！图标就长上面这样，搜索到之后下载到自己的电脑上，然后双击打开，一路狂点下一步，直到安装完成，好了，也没有什么需要注意的地方。安装完成之后，看一下鼠标右键菜单时候有<kbd><font style="background:#445566">Git bash Here</font></kbd>如果有了。那克隆环境就准备好了！</p>
    
    - 配置git
    
    <p>使用git之前，或许我们需要对它进行一点配置，那我们就右击，选择<kbd><font style="background:#445566">Git bash Here</font></kbd>，打开命令窗口，输入</p>

    ```bash
    git config --global user.email "你的邮箱"
    git config --global user.name "你的昵称"
    ```
    好了，如果你想详细了解git的使用你可以去[廖雪峰的官方网站](https://www.liaoxuefeng.com/wiki/0013739516305929606dd18361248578c67b8067c8c017b000)学习(高手的站点，你懂的)，好了，这里就全部准备结束了!
- #### 克隆命令的使用

    首先确定好你项目放置的位置，比如在D:\JEE\路径下，那你就在d:\jee下点击右键-><kbd><font style="background:#445566">Git bash Here</font></kbd>，在打开的命令窗口中输入：

    ```bash
    git clone https://github.com/ZMR2194888146/eshop.git
    ```
    好了就开始克隆了，克隆结束之后，使用NetBeans打开就可以接着继续工作了，如果你获得更新后的代码，你可以使用

    ```bash
    git pull
    ```
    来获取最新的代码，But，由于你可能修改过你之前克隆的代码，所以在你进行pull操作是会遇到冲突，那就需要你自己去解决了，Bay,全部关于此代码的使用都在这里了，剩下的交给你了！

#
> ### <h2 id="stentcebeforuse">使用中的一点声明</h2>
- 忘记了说,数据库密码是sqlserver2008,如果需要修改,可以去config.Config中password的值
- 代码是我自己一行一行的打出来的，而且我是新手，避免不了出错，如果出错被你修复后，你愿意分享的话，你可以创建新的分支后进行推送。
- 还有，这是张厚华老师的课上作业，改怎么弄，你自己看着办吧！ヽ(･ω･´ﾒ)