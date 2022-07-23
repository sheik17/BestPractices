package com.chainsys.bestPractices.references;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

public class Lessons {
	public static void testA() {
		List<Phone> phoneList = new ArrayList<Phone>();
//     Phone.print();  direct call does not worked
		phoneList.add(new Phone());
		phoneList.add(new Phone());
		phoneList.add(new Phone());
		phoneList.add(new Phone());
		phoneList.add(new Phone());
		phoneList.add(new Phone());
		phoneList.forEach(System.out::println);
	}

	public static void testB() {
		List<Long> Phonenumber = new ArrayList<Long>();
		Phonenumber.add(9384324894L);
		Phonenumber.add(9344074238L);
		Phonenumber.add(9994723796L);
		Phonenumber.add(9384324894L);
		Phonenumber.add(9384324893L);
		Phonenumber.add(9384323894L);
		Phonenumber.forEach(Phone::print); // static method call-> using class to call static method
		Phone iphone = new Phone();
		Phonenumber.forEach(iphone::makeaCall); // non-static method -> using object reference to call instant method
												// name ::method name

	}
//	Constructor reference

	public static void testC() {
		PhoneEmpty mobileA = Phone::new;
//      constructor reference
		Phone firstPhone = mobileA.get(); // factory method
		firstPhone.makeaCall(9344074238L);
		PhoneWithNumberModel mobileB = Phone::new;
//		parameterized constructor call
		Phone secondPhone = mobileB.get(9994723796L, "5GiPhone 13Pro"); // factory method
		secondPhone.makeaCall(8526575018L);
		System.out.println(secondPhone.toString());
	}

	public static void testD() {
		Map<Long, String> phoneMap = new HashMap<Long, String>();
		phoneMap.put(88864372962L, "samsung");
		phoneMap.put(98345445852L, "oppo");
		phoneMap.put(872354539827L, "nokia");
		phoneMap.put(87298832745L, "redmi");
		phoneMap.put(8176545385L, "oneplus");
//		map does not have stream because it is not a collection
//		phoneMap.stream()
		Set<Long> longSet = phoneMap.keySet();
		Stream<Long> numberStream = phoneMap.keySet().stream();
//		map has to be converted to a set and stream method should be called on set

		Phone[] phonearray = numberStream.map(Phone::new) // constructor reference of phone
				.toArray(Phone[]::new); // constructor reference of array
//		int count = phonearray.length;
//		for (int i = 0; i < count; i++) {
//			System.out.println(phonearray[i]);
//		}
//	    Stream<Phone> phonearray.stream(); // you cannot(directly use) calls stream() in a array
//		creating a stream from arrays
//		another method for above command lines
		Stream<Phone> phoneStream = Arrays.stream(phonearray);
		phoneStream.forEach(System.out::println);
//		its the another method for command lines below
//		Arrays.stream(phonearray).forEach(System.out::println);
	}
}

// Functional interface for - non parameterized constructor
interface PhoneEmpty {
	Phone get();
}

// Functional interface for - parameterized constructor
interface PhoneWithNumberModel {
	Phone get(long number, String model);
}

class Phone {
	private long number;
	private String model;

	public Phone() {
		System.out.println("Default Constructor");

	}

	public Phone(long number, String model) {
		System.out.println("Parameterized Constructor");
		this.number = number;
		this.model = model;
	}

	public Phone(long number) {
		System.out.println("Single parameter Constructor");
		this.number = number;
		this.model = "not assigned";
	}

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void makeaCall(long number) {
		System.out.println("Call ring to - " + number);
	}

	public static void print(long number) {
		System.out.println("Print document : " + number);
	}

	@Override
	public String toString() {
		return this.number + " " + this.model;
	}
}
