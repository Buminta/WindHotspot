package xyz.windjs.android.utils;

import java.util.ArrayList;
import java.util.HashMap;

import xyz.windjs.android.ui.Call;

/**
 * Created by me866chuan on 7/1/16.
 */
public class WindHotspot {

    HashMap<String,ArrayList<Call>> listHashMap = new HashMap<>();

    public static WindHotspot windHotspot;

    public static void init(){
        if (windHotspot == null) {
            windHotspot = new WindHotspot();
        }
    }

    public static WindHotspot getInstance(){
        return windHotspot;
    }

    public void bind(String name, Call call){
        for(int i=0; i<listHashMap.size(); i++){
            if (listHashMap.containsKey(name)){
                listHashMap.get(name).add(call);
                return;
            }
        }
        listHashMap.put(name, new ArrayList<Call>());
        listHashMap.get(name).add(call);
    }

    public void unbind(String name, Call call){
        for(int i=0; i<listHashMap.size(); i++){
            if (listHashMap.containsKey(name)){
                listHashMap.get(name).remove(call);
                return;
            }
        }
    }

    public void call(String name, Object... objectes){
        for(int i=0; i<listHashMap.size(); i++){
            if (listHashMap.containsKey(name)){
                ArrayList<Call> list = listHashMap.get(name);
                for(int j=0; j<list.size(); j++){
                    list.get(j).run(objectes);
                }
                return;
            }
        }
    }
}
