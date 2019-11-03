# Auto Recycler Adapter & Smart Recycler Adapter
[![GitHub license](https://img.shields.io/badge/license-MIT-blue.svg?style=flat-square)](https://raw.githubusercontent.com/cubesky/AutoRecyclerAdapter/master/LICENSE)  

This library can help you to control RecyclerView in an easiest way.  
> _Warning: This library using an ugly way and it has some performance issue!_  
> Now you can use ARALib and SmartRecyclerAdapter to improve performance.

This library is under development. You can use this by import [CubeSky Repo](https://cubesky-mvn.github.io)

From version 2.0, SmartRecyclerAdapter moved to AndroidX insteadof AppCompat.  

## Smart Recycler Adapter  
Smart Recycler Adapter finished in version 1.0, it use Annotation Processor to auto generate source code when you compile, so it doesn't cause any performanse issue.  

### One more import
After import main library using CubeSky Repo, you need add more library to your `build.gradle` file. Use main library version code instead of `<version>` in example.  
```groovy
dependencies {
    compileOnly 'party.liyin:aralib:<version>'
    annotationProcessor 'party.liyin:aralib-processor:<version>'
}
```  

### How to use
First, you need a layout. Create a layout file for your data which want to display. Eg. `R.layout.datacard`  
And then, you need add some code to your code to init adapter.  

```java
SmartRecyclerAdapter adapter = new SmartRecyclerAdapter(context);
RecyclerView recyclerView = findViewById(R.id.recyclerView);
recyclerView.setLayoutManager(new LinearLayoutManager(this));
recyclerView.setAdapter(adapter);
```

Then, you need a JavaBean to extends `AutoDataBean` with `ARABind` annotation to bind your data to the view.    
Instead of old `AutoBind` system, `ARABind` use resource id as `view_id` and use Class as `view_type` to simplify your code. In `ARABind` view_param is optional, it only used with multi parameter method.  
And then, add `ARABindLayout` annotation to Class to tell adapter witch layout should it use, it will automatically bind to it.  
> If you need  `view_param`, please use boxed Object such as Integer and Float instead of int and float.  
> In `SmartRecyclerAdapter` fields must be public modifier!  

```java
@ARABindLayout(R.layout.datacard)
public class DataCardBean extends AutoDataBean {
        @ARABind(view_id = R.id.textView, view_type = TextView.class, view_method = "setText")
        public String data;
        @ARABind(view_id = R.id.textView, view_type = TextView.class, view_method = "setTextSize", view_param = { Integer.class, Float.class })
        public Object[] size;
        DataCardBean(String data, int unit, float size) {
            this.data = data;
            this.size = new Object[]{unit, size};
        }
}
```

Other methods support by `Auto Recycler Adapter` is also support in `Smart Recycler Adapter`. You can use them as usual.   

## Auto Recycler Adapter
Auto Recycler Adapter using Reflection in Runtime to setting value to View. This will cause performance issue. But early then version 1.0 (Not include), you can only use this, I keep it as compatibility.  
From version 2.0, AutoRecyclerAdapter mark as Deprecated, you should not use this.  

### How to use
First, you need a layout. Create a layout file for your data which want to display. Eg. `R.layout.datacard`  
And then, you need add some code to your code to init adapter.  

```java
AutoRecyclerAdapter adapter = new AutoRecyclerAdapter(context);
RecyclerView recyclerView = findViewById(R.id.recyclerView);
recyclerView.setLayoutManager(new LinearLayoutManager(this));
recyclerView.setAdapter(adapter);
```

Then, you need a JavaBean to extends `AutoDataBean` with `AutoBind` annotation to bind your data to the view.  

```java
class DataCardBean extends AutoDataBean {
        @AutoBind(view_id = "xxxTextView",view_method = "setText",view_param = CharSequence.class)
        protected String data;
        @AutoBind(view_id = "xxxTextView", view_method = "setTextSize", view_param = {int.class, float.class})
        protected Object[] size;
        DataCardBean(String data, int unit, float size) {
            this.data = data;
            this.size = new Object[]{unit, size};
        }
}
```

And now, you need bind them together.  

```java
autoRecyclerAdapter.bindView(DataCardBean.class, R.layout.datacard);
```

**After Version 0.6, you can use @AutoBindView for AutoDataBean**  
```java
@AutoBindView(R.layout.datacard)
class DataCardBean extends AutoDataBean {
        @AutoBind(view_id = "xxxTextView",view_method = "setText",view_param = CharSequence.class)
        protected String data;
        @AutoBind(view_id = "xxxTextView", view_method = "setTextSize", view_param = {int.class, float.class})
        protected Object[] size;
        OneDataBean(String data, int unit, float size) {
            this.data = data;
            this.size = new Object[]{unit, size};
        }
}
```  
No need to call `adapter.bindView` Method!  

After, you can use  

```java
adapter.addData(new DataCardBean("Hello", TypedValue.COMPLEX_UNIT_PX, 30f), ...)
```

to add data.  
And use  
```java
adapter.remove(0); //position
```

to remove data, or `adapter.clear();` to clear all data.  

If you want to control the data list on your self. Just run these to get raw data list.   
```java
ArrayList<AutoDataBean> list = adapter.getItemList();
```

Remember, if you control this list in your way, you need to call `adapter.notifyDataSetChanged();` to tell adapter to refresh the list on the view.  

#### ShortCut
If you have any layout doesn't need any data. you can use `EmptyDataBean.getEmptyLayout(R.layout.layout_xxx)` to get a special AutoDataBean. Just add it to the adapter, everything is done.  
If you use this `EmptyDataBean` to add layout with no dynamic data. It will have some performance improve by skip reflection and data inject in the background.  

## License
MIT