package javaee.collection.foreach;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
//        for(String s:list){
//            if("bbb".equals(s)){
//                list.add("ddd");
//            }
//        }
//        Iterator it = list.iterator();
//        while(it.hasNext()){
//            if("bbb".equals(it.next())){
//                list.add("ddd");
//            }
//        }

//        for(String s:list){
//            if("bbb".equals(s)){
//                list.remove("ccc");
//            }
//        }
        for(int i=0;i<list.size();i++){
            if("bbb".equals(list.get(i))){
                list.remove(i);
            }
        }
          //while (list.)

        System.out.println(list.toString());
    }
}
