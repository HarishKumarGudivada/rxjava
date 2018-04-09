package com.reactive.demo;

import java.util.ArrayList;
import java.util.List;

import com.reactive.ReactiveJava1;
import com.reactive.beans.EmployeeInfo;

import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class Demo1 {

	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
		List<EmployeeInfo> list=new ArrayList<EmployeeInfo>();
		list.add(new EmployeeInfo(1,"Harish",20000));
		list.add(new EmployeeInfo(2,"Teja",30000));
		list.add(new EmployeeInfo(3,"manoj",10000));
		
		Observable<EmployeeInfo> obs=ReactiveJava1.getFeed(list);
		/*obs.subscribe(new Action1<EmployeeInfo>() {

			@Override
			public void call(EmployeeInfo arg0) {
				System.out.println("Emp : "+arg0);
			}
		});*/
		
		//obs.subscribe(System.out::println,System.out::println);
		//subscribeOn(Schedulers.io())
		obs.subscribe(new Subscriber() {

			@Override
			public void onCompleted() {
				System.out.println("No More Data !!");
			}

			@Override
			public void onError(Throwable arg0) {
				System.out.println(arg0.getMessage());
			}

			@Override
			public void onNext(Object arg0) {
				EmployeeInfo inf=(EmployeeInfo)arg0;
				System.out.println(arg0);
				if(inf.getSalary()>21000){
					System.out.println("Thank You I am Done ... No Need to subscribe");
					unsubscribe();
				}
			}
		});
		
		System.out.println("Did i get it");
		Thread.sleep(10000);
	}
}
