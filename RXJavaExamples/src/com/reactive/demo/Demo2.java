package com.reactive.demo;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;

public class Demo2 {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws InterruptedException {

		List<Integer> empInf=new ArrayList<Integer>();
		for (int i = 0; i < 5; i++) {
			empInf.add(i);
			Thread.sleep(100);
		}
		
		Observable obs=	Observable.from(empInf);
		obs.subscribe(s->{
			System.out.println("Items:"+s);
			});
		System.out.println("Did i get it");
	}
}
