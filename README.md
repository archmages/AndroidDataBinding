Android Data Binding(More Xml, Less Java)
---  
![image](http://ww3.sinaimg.cn/large/53488390gw1ez56f8bydnj2040040747.jpg)

# 背景
Google在2015年的I/O大会上发布了三个重要的支持库：    

* Material Design支持库：Android Support Design  
* 百分比布局支持库：Percent support lib  
* <font color=#FF69B4>**数据绑定支持库：Data Binding Library**</font>

# Data Binding有什么作用
* 是官方支持的[MVVM](https://www.objc.io/issues/13-architecture/mvvm/)模式框架
* 可以直接在静态布局XML中绑定数据，无需再findViewById,然后再手动设置数据  

  `Question:是不是RoboGuice、AndroidAnotations...这样的依赖注入框架会慢慢淡出市场`
* 可以提高解析XML的速度
* UI与功能解耦

# Data Binding的需求与支持
## 需求
* Android Studio 1.3.0-beta1 或更高版本
* Gradle plugin 1.3.0以上

## 支持
* Android 2.1(API level 7+)以上


# 如何使用Data Binding
## 配置
### Gradle 插件为1.3的配置
在工程的根build.gradle文件中配置如下：  

```
dependencies {
    classpath 'com.android.tools.build:gradle:1.3.1'
    classpath 'com.android.databinding:dataBinder:1.+'
}
```

在app的build.gradle文件中配置如下：  

```
apply plugin: 'com.android.application'
apply plugin: 'com.android.databinding'
```

### Gradle 插件为1.5.+的配置：
只需要在app的build.gradle文件中如下配置就ok:  

```
android {
    ....
    dataBinding {
        enabled = true
    }
}
```
## 使用流程
### 第一步：创建XML
```
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android">
   <data>
       <variable name="user" type="com.example.User"/>
   </data>
   <LinearLayout
       android:orientation="vertical"
       android:layout_width="match_parent"
       android:layout_height="match_parent">
       <TextView android:layout_width="wrap_content"
           android:layout_height="wrap_content"
           android:text="@{user.firstName}"/>
       <TextView android:layout_width="wrap_content"
           android:layout_height="wrap_content"
           android:text="@{user.lastName}"/>
   </LinearLayout>
</layout>
```

### 第二步：定义数据
```
public class User {
   public final String firstName;
   public final String lastName;
   public User(String firstName, String lastName) {
       this.firstName = firstName;
       this.lastName = lastName;
   }
}
```
### 第三步：绑定数据  
```    
@Override
protected void onCreate(Bundle savedInstanceState) {
   super.onCreate(savedInstanceState);
   MainActivityBinding binding = DataBindingUtil.setContentView(this, R.layout.main_activity);
   User user = new User("Test", "User");
   binding.setUser(user);
```
# Data Binding使用之详细介绍
### 使用类方法  
```
<data>
    <import type="com.example.MyStringUtils"/>
    <variable name="user" type="com.example.User"/>
</data>
<TextView
   android:text="@{MyStringUtils.capitalize(user.lastName)}"
   android:layout_width="wrap_content"
   android:layout_height="wrap_content"/>
```
### 类型别名  
```
	<data>
        <import type="archmages.github.databindingsamples.model.User"/>
        <import type="archmages.github.databindingsamples.model.real.User" alias="RealUser"/>
        <variable
            name="user"
            type="RealUser"/>
    </data>
    <TextView
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text='@{user.firstName}'/>	
```

### Null Coalescing运算符
空聚合运算操作（??）， 如果左边的运算对象不为空的话选择左边，否则选择右边  
```
android:text="@{user.displayName ?? user.lastName}"
```
  
这个运算等价于:  
```
android:text="@{user.displayName != null ? user.displayName : user.lastName}"
```
### 使用属性值  
  
如下，我们要使用View的Visible属性：  

```
<data>
    <import type="android.view.View"/>
</data>
<TextView
   android:text="@{user.lastName}"
   android:layout_width="wrap_content"
   android:layout_height="wrap_content"
   android:visibility="@{user.isAdult ? View.VISIBLE : View.GONE}"/>
```
### 使用资源数据    
Data Binding也是支持直接访问资源数据的
  
```
android:padding="@{large? @dimen/largePadding : @dimen/smallPadding}"
```  
  

### 带ID的View
**Data Binding** 有效降低了代码的冗余性，甚至完全没有必要再去获取一个 View 实例，万一我们真的就需要的时候，只要给 View 定义一个 ID，Data Binding 就会为我们生成一个对应的 final 变量。  
  
```
<layout xmlns:android="http://schemas.android.com/apk/res/android">
   <data>
       <variable name="user" type="com.example.User"/>
   </data>
   <LinearLayout
       android:orientation="vertical"
       android:layout_width="match_parent"
       android:layout_height="match_parent">
       <TextView android:layout_width="wrap_content"
           android:layout_height="wrap_content"
           android:text="@{user.firstName}"
   		   android:id="@+id/firstName"/>
       <TextView android:layout_width="wrap_content"
           android:layout_height="wrap_content"
           android:text="@{user.lastName}"
  		   android:id="@+id/lastName"/>
   </LinearLayout>
</layout>
```    
Data Binding会自动生成成员变量 ：   
 
```
public final TextView firstName;
public final TextView lastName;
```    
这样我们通过binding对象，可以直接访问这些View, 如此之方便

### List View Item  
    
如果我们在ListView中或者在RecyclerView中使用Data Binding, 我们需要在Adapter中这样写（以ListView为例）：

```
@Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewDataBinding binding = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()),
                R.layout.user_list_item_view, viewGroup, false);
        binding.setVariable(BR.user, users.get(i));
        binding.executePendingBindings();
        return binding.getRoot();
    }
```  
### Includes  

有时候我们为了避免layout的xml写得过长，有一些共用的View会抽出来，通过include的方式加入xml中，Data Binding也支持include binding, 我们如何传递binding给include layout呢？ 通过Application命名空间 `bind:`和变量名`@{...}`  

```
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:bind="http://schemas.android.com/apk/res-auto">
   <data>
       <variable name="user" type="com.example.User"/>
   </data>
   <LinearLayout
       android:orientation="vertical"
       android:layout_width="match_parent"
       android:layout_height="match_parent">
       <include layout="@layout/name"
           bind:user="@{user}"/>
       <include layout="@layout/contact"
           bind:user="@{user}"/>
   </LinearLayout>
</layout>
```
### 空指针安全
Data Binding自动会检查空对象并且避免空指针异常，例如：在表达式：`@{user.name}`中，如果`user`是null, `user.name`会被指定一个默认值`null`, 如果我们用`@{user.age}`, 这个地方age是int型，那么当user为null的时候，`user.age`默认是0
### Collections    
常用集合类型，Data Binding都支持：arrays, lists, sparse lists, and maps  

```
<data>
    <import type="android.util.SparseArray"/>
    <import type="java.util.Map"/>
    <import type="java.util.List"/>
    <variable name="list" type="List&lt;String>"/>
    <variable name="sparse" type="SparseArray&lt;String>"/>
    <variable name="map" type="Map&lt;String, String>"/>
    <variable name="index" type="int"/>
    <variable name="key" type="String"/>
</data>
android:text="@{list[index]}"
android:text="@{sparse[index]}"
android:text="@{map[key]}"
```  

**[备注]**  
这边大家注意：在xml中`<`是特殊字符，当引用List, Map...时，左尖括号需要用转义字符`&lt;`替换, 同时，引号`"`要用`&quot;`替换
### 表达式
##### Data Binding支持常用表达式：  

* Mathematical + - / * %
* String concatenation +
* Logical && ||
* Binary & | ^
* Unary + - ! ~
* Shift >> >>> <<
* Comparison == > < >= <=
* instanceof
* Grouping ()
* Literals - character, String, numeric, null
* Cast
* Method calls
* Field access
* Array access []
* Ternary operator ?:

# 前景和展望  
* 目前Android Databinding还只支持单向绑定，试想未来是否能像Angular.Js一样支持双向绑定呢？
* 由于目前Android Data Binding还是测试版，[buck](https://github.com/facebook/buck)官方说等Android Databinding升级到正式版本后才考虑对其支持

我谷歌大法一直在与时俱进，每年的I/O大会都会给出重量级的产品，期待上述两个Features的实现，如果真是这样的话，Android不管是开发速度还是编译速度都飞速提高😀
