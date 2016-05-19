package com.vikas.coreconcepts;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ArrayBlockingQueue;

public class CoreConcepts {

	private Integer[] arr = null;
	private int totalNumbers = 10;
	private int sumOfAll = 0;
	private int sumOfCurrent = 0;

	enum Case {
		MISSING("findMissing"), DUPLICATE("findDuplicate"), REMOVE_DUPLICATES("removeDuplicates"), FIND_DUPLICATES("findDuplicates"),
		REMOVE_DUPLICATES_BY_SET("removeDuplicateBySet"), FIBONACCI("fibonacci"), SINGLETON("singleton"), HACK_SINGLETON("hackSingleton"),
		ENUM_SINGLETON("enumSingleton"), HACK_ENUM("hackEnumSingleton"), DEADLOCK("findDeadlock"),FIND_DUPLICATE_WO_COLLECTIONS("findDuplicateWithoutCollections") ,PASS("");

		private String method;

		private Case(String method) {
			this.method = method;
		}


	};

	private void findMissing() {

		arr = new Integer[]{1,3,5,7,4,9,8,10,6};

		for(int i=0; i<arr.length; i++){
			sumOfCurrent+= arr[i];
		}

		sumOfAll= (totalNumbers * (totalNumbers+1))/2;

		System.out.println("Total Numbers: "+arr.length);

		System.out.println("Sum -> Current= "+sumOfCurrent + " Total= "+sumOfAll);

		System.out.println("Missing Number: "+ (sumOfAll - sumOfCurrent));

	}

	private void findDuplicate(){

		int  highestNumber = 0;

		arr = new Integer[]{1,3,5,7,4,9,8,10,6,9,2};

		Arrays.sort(arr);

		highestNumber = arr[arr.length-1];

		sumOfAll = ( highestNumber * (highestNumber + 1))/2;

		for(int i=0; i<arr.length; i++){
			sumOfCurrent+= arr[i];
		}

		System.out.println("Total Numbers: "+arr.length+" Highest Number: "+highestNumber);

		System.out.println("Sum -> Current= "+sumOfCurrent + " Total= "+sumOfAll);

		System.out.println("Duplicate Number: "+ (sumOfCurrent - sumOfAll));
	}


	private void removeDuplicates() {
		arr = new Integer[]{1,3,5,7,4,9,8,10,6,9,2,2,5,4};

		Set<Integer> mySet = new HashSet<Integer>();

		mySet.addAll(Arrays.asList(arr));

		Iterator<Integer> it = mySet.iterator();

		while(it.hasNext()) {
			System.out.print(" "+it.next());			
		}

	}

	private void findDuplicates(){
		arr = new Integer[]{1,3,5,7,4,9,8,10,6,9,2,2,5,4,4,2};

		List<Integer> dupList = new ArrayList<Integer>();

		Map<Integer,Integer> myMap = new HashMap<Integer,Integer>();

		for(int i=0;i<arr.length;i++){
			if(!myMap.containsValue(arr[i])){ 
				myMap.put(i,arr[i]);
				//				System.out.print(" "+myMap.get(i));
			}
			else {
				dupList.add(arr[i]);
			}
		}
		System.out.println("");
		System.out.print("Duplicates: ");
		for(Integer i: dupList) {
			System.out.print(" "+i);
		}

		Iterator<Integer> it = myMap.values().iterator();
		System.out.print("\n Values: ");

		while(it.hasNext()){
			System.out.print(" "+it.next());
		}
	}

	private void removeDuplicateBySet(){

		arr = new Integer[]{1,14,5,3,4,9,8,10,6,9,2,2,5,4,4,2};

		List<Integer> dupList = new ArrayList<Integer>();

		Set<Integer> mySet = new HashSet<Integer>();
		
//		mySet.addAll(Arrays.asList(arr));
		
		for(int i=0;i<arr.length;i++){
			//			if(!myMap.containsValue(arr[i])){ 
			mySet.add(arr[i]);
			//	System.out.print(" "+myMap.get(i));
			/*	}
			else {
				dupList.add(arr[i]);
			}*/
		}
		/*System.out.println("");
		System.out.print("Duplicates: ");
		for(Integer i: dupList) {
			System.out.print(" "+i);
		}*/

		//		Collection<Integer> c =  myS.values();

		Iterator<Integer> it = mySet.iterator();
		System.out.print("Set Values: ");

		while(it.hasNext()){
			System.out.print(" "+it.next());
		}

	}

	private void fibonacci(){
		int num=10;
		int sum=0;
		int prev=0;
		int next=1;

		for(int i=0;i<num;i++){			 
			System.out.print(" "+prev);
			sum=prev+next;
			prev=next;
			next=sum;
		}
	}

	private void testSingleton(){

		MySingleton mySigObj = MySingleton.getInstance();
		mySigObj.print();
	} 


	private void hackSingleton(){
		
		try {
			Class myClass = Class.forName("com.vikas.coreconcepts.MySingleton");
			
			Constructor<MySingleton> cons = myClass.getDeclaredConstructor(null);
			cons.setAccessible(true);

			MySingleton classObj = (MySingleton)cons.newInstance(null);
			
			classObj.hackedPrint();		
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 		
		
	}
		
	private void enumSingleton() {
		
		MySingletonEnum obj = MySingletonEnum.INSTANCE;
		
		obj.print();
		
	}
	
	private void hackEnumSingleton(){
		
	try {
		Class cls = Class.forName("com.vikas.coreconcepts.MySingletonEnum");
		
		Constructor<MySingletonEnum> cons = cls.getDeclaredConstructor(null);
		cons.setAccessible(true);

		MySingletonEnum obj = cons.newInstance(null);
		
		obj.print();
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SecurityException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (NoSuchMethodException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IllegalArgumentException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (InstantiationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IllegalAccessException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (InvocationTargetException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}

	
	private void producerConsumer(){
		
		ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(2);
		
		Producer p = new Producer(queue); 
		
		Consumer c = new Consumer(queue);	
		
		new Thread(p).start();
		
		new Thread(c).start();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Integer count = 0;
		
	}
	
	
	private void oldProducerConsumer(){
		
		Integer count = 0;
		
		OldConsumer o = new  OldConsumer(count);
		
		OldProducer p = new OldProducer(count);
		
		new Thread(p).start();
		new Thread(o).start();
		
		/*try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
	}
	
	private void deadlock(){
		
		DeadLock d = new DeadLock();
		
		d.t1.start();
		
		d.t2.start();
	}
	
	private void findDupsWithoutCollections(){
		
		int arr[] = {6, 3, 1, 5, 10, 2, 9};

		int max1 = 0, max2 =0;
		
		for(int i : arr){
			
			if(max1 < i) {
				
				max2 = max1;
				max1 = i;
			}
			else if (max2 < i){
				max2 = i;
			}
		}
		System.out.println("Max 1: "+max1+" Max2: "+max2);
		
	}
	
	private void sortMapByValue(){
		
		Map<Integer, Integer> myMap = new HashMap<Integer, Integer>();
		
		myMap.put(1, 2);
		myMap.put(2, 4);
		myMap.put(3, 7);
		myMap.put(4, 10);
		myMap.put(5, 1);
	
		
		Set<Entry<Integer, Integer>> mySet = myMap.entrySet();
		List<Entry<Integer,Integer>> list = new ArrayList<Entry<Integer,Integer>>(mySet);
		Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>(){
			@Override
			public int compare(Entry<Integer,Integer> o1, Entry<Integer,Integer> o2) {
				return (((Integer) o2.getValue()).compareTo(o1.getValue()));
			}
		});
		
		for(Map.Entry<Integer, Integer> entry: list){
			
			System.out.println("Key: "+entry.getKey()+" Value: "+entry.getValue());
		}		
	}
	
	private void sortMapByValueTreeMap(){
		
		Map<Integer, Integer> myTreeMap = new TreeMap<Integer, Integer>();
		myTreeMap.put(4, 10);
		myTreeMap.put(5, 1);
		myTreeMap.put(1, 2);
		myTreeMap.put(3, 7);
		myTreeMap.put(2, 4);
		
		for(Map.Entry<Integer, Integer> entry: myTreeMap.entrySet()){
			
			System.out.println("Key: "+entry.getKey()+" Value: "+entry.getValue());
		}	
		
		System.out.println("..............");
		
		Map<Integer, Integer> myMap = new HashMap<Integer, Integer>();
		myMap.put(14, 10);
		myMap.put(5, 1);
		myMap.put(11, 2);
		myMap.put(73, 7);
		myMap.put(92, 4);
		
		for(Map.Entry<Integer, Integer> entry1: myMap.entrySet()){
			
			System.out.println("Key: "+entry1.getKey()+" Value: "+entry1.getValue());
		}	
		
	}
	
	private void reverseNumber(){
		int number = 192;
		int reverse = 0;
        while(number != 0){
            reverse = (reverse*10)+(number%10);
            number = number/10;
        } 
        System.out.println(reverse);
		
	}
	
	public static void main(String[] args) {

		CoreConcepts cc = new CoreConcepts();

//		cc.producerConsumer();
//		cc.oldProducerConsumer();
		
//		cc.deadlock();
		
//		cc.sortMapByValue();
		
//		cc.sortMapByValueTreeMap();
		
		cc.reverseNumber();
		
		Case c = Case.PASS;		

		switch(c){
		case  DUPLICATE:
			cc.findDuplicate();
			break;

		case MISSING:
			cc.findMissing();
			break;

		case REMOVE_DUPLICATES:
			cc.removeDuplicates();
			break;

		case FIND_DUPLICATES:
			cc.findDuplicates();
			break;

		case REMOVE_DUPLICATES_BY_SET:
			cc.removeDuplicateBySet();
			break;

		case FIBONACCI:
			cc.fibonacci();
			break;

		case SINGLETON:
			cc.testSingleton();
			break;
			
		case HACK_SINGLETON:
			cc.hackSingleton();
			break;
			
		case ENUM_SINGLETON:
			cc.enumSingleton();
			break;
			
		case HACK_ENUM:
			cc.hackEnumSingleton();
			break;
			
		case DEADLOCK:
			cc.deadlock();
			break;
		
		case FIND_DUPLICATE_WO_COLLECTIONS:
			cc.findDupsWithoutCollections();

		case PASS:	
			break;
		}

	}

}
