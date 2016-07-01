# WindHotspot for Android
Bind and Unbind custom everyone events with everyone arguments method in everywhere


## Register event 

### #1
```
Call call = new Call() {
            @Override
            public void run(Object... objectes) {
                if(objectes.length > 1) Log.d("OK Event", (String) objectes[0]); //String object follow with object u call event
            }
        };
WindHotspot.getInstance().bind("TestEvent", call);
```

### #2
```
class YourClass implements Call{
    
    public YourClass(){
      WindHotspot.getInstance().bind("TestEvent", this);
    }

    @Override
    public void run(Object... objectes) {
        Log.e("FUCK", (String) objectes[0]);
    }
}
```

## Unbind Event 

```
WindHotspot.getInstance().unbind("TestEvent", call);
```

## Call Event
```
WindHotspot.getInstance().call("TestEvent", "Rest", 123, object);
```
