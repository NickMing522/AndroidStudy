## 实验3 
### 运行后即会进入到主界面中，有四个按钮对应实验的四个模块
![shoutu](https://img-blog.csdnimg.cn/20200520154313302.png)



#### 点击第一个按钮进入ListView的用法，实现了SimpleAdapter，以及Toast显示选中信息

![ListView](https://img-blog.csdnimg.cn/20200520154313419.png)



#### 点击第二个按钮进入调用AlertDialog实现的自定义对话框

![AlertDialog](https://img-blog.csdnimg.cn/20200520154313411.png)



#### 点击第三个按钮进入使用XML定义菜单的功能，提供了颜色以及字体大小和Toast显示的选项

![XMLMenu](https://img-blog.csdnimg.cn/20200520154313413.png)

##### 选择字体红色，字体大小调节，显示Toast后变化情况

![XMLMenu](https://img-blog.csdnimg.cn/20200520154313405.png)



#### 点击第四个按钮进入ActionMode创建的上下文菜单

这个内容我觉得比较难，自己没有想出来，所以参照了一下老师的源代码，理解了老师的思路。主要还在于实现setMultiChoiceModeListener中的四个方法：

``` setMultiChoiceModeListener
 public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                // TODO Auto-generated method stub
                return false;
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {
                // TODO Auto-generated method stub
            }

            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                // TODO Auto-generated method stub
                return true;
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                // TODO Auto-generated method stub
                return false;
            }

            @Override
            public void onItemCheckedStateChanged(ActionMode mode, int position,
                                                  long id, boolean checked) {
                // TODO Auto-generated method stub
               
            }
```

##### 上截图：

![ActionMode](https://img-blog.csdnimg.cn/20200520154313408.png)
