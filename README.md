# Auto Recycler Adapter
[![GitHub license](https://img.shields.io/badge/license-MIT-blue.svg?style=flat-square)](https://raw.githubusercontent.com/cubesky/AutoRecyclerAdapter/master/LICENSE)  

This library can help you to control RecyclerView in an easiest way.  
> Warning: This library using an ugly way and it has some performance issue!

This library is under development. You can use this by import [CubeSky Repo](https://cubesky-mvn.github.io)

## How to use
First, you need a layout. Create a layout file for your data which want to display. Eg. `R.layout.datacard`  
And then, you need add some code to your code to init adapter.  

```java
AutoRecyclerAdapter adapter = new AutoRecyclerAdapter(context);
RecyclerView recyclerView = findViewById(R.id.recyclerView);
recyclerView.setLayoutManager(new LinearLayoutManager(this));
recyclerView.setAdapter(autoRecyclerAdapter);
```

Then, you need a JavaBean to extends `AutoDataBean` with `AutoBind` annotation to bind your data to the view.  

```java
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

And now, you need bind them together.  

```java
autoRecyclerAdapter.bindView(DataCardBean.class, R.layout.datacard);
```

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

### ShortCut
If you have any layout doesn't need any data. you can use `EmptyDataBean.getEmptyLayout(R.layout.layout_xxx)` to get a special AutoDataBean. Just add it to the adapter, everything is done.  
If you use this `EmptyDataBean` to add layout with no dynamic data. It will have some performance improve by skip reflection and data inject in the background.  

## License
MIT