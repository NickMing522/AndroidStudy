## 实验四

**查看自己的浏览器MyBrowser：**

![1](http://q9cfj5sv8.bkt.clouddn.com/4.1.png)

**点击运行MyApplication4即进入到输入地址框中：**

![2](http://q9cfj5sv8.bkt.clouddn.com/4.2.png)



**然后选择自己写的MyBrowser**

![3](http://q9cfj5sv8.bkt.clouddn.com/4.3.png)

**接着就可以访问了**

![4](http://q9cfj5sv8.bkt.clouddn.com/4.4.png)



---

实验总体不算难，但是里面有个坑我踩了很久才知道：

就是在AndroidManifest.xml文件中，要添加如下内容：

```1
<intent-filter>
                <category android:name="android.intent.category.DEFAULT"/>
                <action android:name="android.intent.action.VIEW"/>
                <category android:name="android.intent.category.BROWSABLE"/>
                <data android:scheme="http"/>
                <data android:scheme="https"/>
                <data android:scheme="file"/>
            </intent-filter>
```

**这其中得和原来的内容分开写，如下：**

```2
<intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
            <intent-filter>
                <category android:name="android.intent.category.DEFAULT"/>
                <action android:name="android.intent.action.VIEW"/>
                <category android:name="android.intent.category.BROWSABLE"/>
                <data android:scheme="http"/>
                <data android:scheme="https"/>
                <data android:scheme="file"/>
            </intent-filter>
```

如果将两个<intent-filter>合并成一个的话，运行起来是不会报错的，但是你会惊喜的发现，模拟器上根本不会产生app
