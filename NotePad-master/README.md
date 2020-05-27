# 安卓期中实验

**在本次实验中，主要改善了NotePad的两个功能，一是增加了查询功能，二是添加了时间戳。**



### **2.增加时间戳**

在这个功能的实现上，主要是通过让原本就已经定义好的修改时间显示出来即可。

**1).修改noteslist.xml文件，添加一个TextView**，做好布局，用于显示时间：

```xml
<TextView
        android:id="@android:id/text2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="214"
        />
```

**2).修改NotesList类中的部分内容：**

在PROJECTION，添加 **COLUMN_NAME_MODIFICATION_DATE**

![time1](https://img-blog.csdnimg.cn/2020052720500525.png)



修改dataColumns和viewIDs:

![time2](https://img-blog.csdnimg.cn/2020052720500527.png)



**3).修改NoteEditer类中的内容**

主要是将时间戳进行一个格式化，转换成我们看得懂的日期形式

![time3](https://img-blog.csdnimg.cn/20200527205455388.png)



以下是展示情况：

![time4](https://img-blog.csdnimg.cn/20200527204608211.png)

### **2.通过标题查询**

在这个功能中实现了模糊查询的功能

**1).首先，先在原本的list_options_menu.xml中添加一个item，用作查询使用**：

```item
<item android:id="@+id/menu_query"
        android:title="@string/menu_query"
        android:alphabeticShortcut='q' />
```



这样我们就有了以下显示情况：

![query1](https://img-blog.csdnimg.cn/20200527205004978.png)

我们要通过这个地方来进行查询。



**2). 我新建了一个类叫做SearchNote类，这个类主要是用于做查询操作，和原本程序自带的NoteList大体相同，最主要的差别在于查询语句：**

```查询
  Cursor cursor = managedQuery(
                getIntent().getData(),           
                PROJECTION,                     
                NotePad.Notes.COLUMN_NAME_TITLE+" like ?",                             
                new String[]{"%"+mKeywords+"%"},                           
                NotePad.Notes.DEFAULT_SORT_ORDER 
        );
```

**这里我通过了在获取查询的文本框内容两边加上“%”来实现模糊查询**



**3).接着我通过创建了一个叫SearchDialog类，这个类继承了DialogFragment，主要用于实现在查询时弹窗以及获取弹窗的内容信息，以此进行查询操作：**

``` 弹窗类
public class SearchDialog extends DialogFragment {
    private Button cancel,search;
    private EditText searchText;
    private String content;

    public SearchDialog() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.search_dialog, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view,Bundle savedInstanceState) {
        searchText=(EditText)view.findViewById(R.id.searchText);
        super.onViewCreated(view, savedInstanceState);
        searchText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                content=charSequence.toString();
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        //查找
        search=(Button)view.findViewById(R.id.search);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (content.length()>0){
                    startActivity(SearchNote.newIntent(getActivity(),content));
                    dismiss();

                }
            }
        });
        //退出
        cancel=(Button) view.findViewById(R.id.cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
    }

```



**4).最后，我们就要通过调用的方式来实现此功能：（在NotesList中新增该菜单选项的监听调用）**

找到定义paste的地方下，添加以下代码

```调用
  case R.id.menu_query:
                SearchDialog dialog=new SearchDialog();
                dialog.show(getFragmentManager(),null);
```



以下是运行结果图：

![query2](https://img-blog.csdnimg.cn/2020052720500534.png)

查询结果：

![query3](https://img-blog.csdnimg.cn/20200527205004983.png)



### 3.总结

这两个功能的实现过程其实并没有那么困难，但我实际也花了挺长时间才完成，最主要的原因是自身的安卓开发编程能力薄弱，有些内容并不是很清楚就上手用，让自己有时候云里雾里的。

其实里面最主要的地方在于与数据库的交互操作，掌握了这部分内容就好写些了。本次实验对我的安卓开发编程能力还是有所提升的，让我对于与数据库的操作有了更加深刻的认识。
