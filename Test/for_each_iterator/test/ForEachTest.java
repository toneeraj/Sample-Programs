package test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
  * 
  * @author Neeraj Singh
  **/
public class ForEachTest {  
   
    public static void main(String args[]){
        Collection<String> list = new ArrayList<String>();
        list.add("Android");
        list.add("iPhone");
        list.add("Windows Mobile");
       
        // Which Code will throw ConcurrentModificationException, both, 
        //Should be called remove on iterator

        // none or one of them
        System.out.println(list);   
        // example 1        
        Iterator<String> itr = list.iterator();
        while(itr.hasNext()){
            String lang = itr.next();
           // list.remove(lang);
            itr.remove();
        }
        
        System.out.println(list);
       
         // example 2
//        for(String language: list){
//            list.remove(language);
//        }
    }
}



