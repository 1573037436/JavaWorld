package com.zzj.javaSE.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

/**
 * java内置四大核心函数式接口
 * <p>
 * 1.Consumer<T>消费型接口 无返回值  void accept（T t）
 * 2.Supplier<T>供给型接口 T get();
 * 3.Function<T>函数型接口 R apply(T t)
 * 4.Predicate<T>断言型接口 用于做判断操作 boolean test(T t)
 */
public class LambdaTest {
	 //Consumer<T>
    @Test
    public void test1() {
        //happy(10.15, (x) -> System.out.println(x));
    	String[] atp = {"Rafael Nadal", "Novak Djokovic",  
    		       "Stanislas Wawrinka",  
    		       "David Ferrer","Roger Federer",  
    		       "Andy Murray","Tomas Berdych",  
    		       "Juan Martin Del Potro"};  
    		List<String> players =  Arrays.asList(atp);  
    		  
    		// 以前的循环方式  
    		/*for (String player : players) {  
    		     System.out.print(player + "; ");  
    		} */ 
    		  
    		// 使用 lambda 表达式以及函数操作(functional operation)  
    		//players.forEach((a) -> System.out.print(a + "; "));  
    		   
    		// 在 Java 8 中使用双冒号操作符(double colon operator)  
    		//players.forEach(System.out::println); 
    		//输出list中匹配的值
    		String bString=players.stream().filter(x->x=="Rafael Nadal").findAny().get();
    		System.out.println(bString);
    		
    		List<String> stringCollection=new ArrayList<>();
    		stringCollection.add("baaaa");
    		stringCollection.add("bbbb");
    		stringCollection.add("bcccc");
    		//匹配任一个
    		boolean anyStartsWithA = 
    			    stringCollection
    			        .stream()
    			        .anyMatch((s) -> s.startsWith("a"));
    			System.out.println(anyStartsWithA);      
    		//匹配所有
			boolean allStartsWithA = 
			    stringCollection
			        .stream()
			        .allMatch((s) -> s.startsWith("b"));
			System.out.println(allStartsWithA);     
			//反向匹配
			boolean noneStartsWithZ = 
			    stringCollection
			        .stream()
			        .noneMatch((s) -> s.startsWith("z"));
			System.out.println(noneStartsWithZ);    


    }

    //happy
    public void happy(double money, Consumer<Double> con) {
        con.accept(money);
    }


    //Supplier<T> 产生指定个数的随机数,存入集合
    @Test
    public void test2() {
    	this.getNumber(10, () -> (int) (Math.random() * 100));
    }

    public List<Integer> getNumber(int num, Supplier<Integer> sup) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
        	list.add(sup.get());
        }
        //过滤掉小于50的数字
        Stream liStream=list.stream().filter(a->a>50);
        list=(List<Integer>) liStream.collect(Collectors.toList());
        
        //循环输出list
        list.forEach(a->System.out.print(a + "; "));
        return list;
    }


    //Predicate<T>
    @Test
    public void test3() {
        List<String> strList = Arrays.asList("Mike", "Lee", "Yan");
        //返回满足条件的集合
        List<String> list=strList.stream().filter((x) -> x.length() > 3).collect(Collectors.toList());
        
        //使用时设置条件
        //List<String> list = this.filterStr(strList, (x) -> x.length() > 3);
        list.forEach(System.out::print);
    }

    //将满足条件的字符串 存入集合中
    public List<String> filterStr(List<String> str, Predicate<String> pre) {
        List<String> list = new ArrayList<>();

        for (String s : str) {
            if (pre.test(s)) {
                list.add(s);
            }
        }
        return list;
    }

}
