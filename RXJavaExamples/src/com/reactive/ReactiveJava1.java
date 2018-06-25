package com.reactive;


import java.util.List;

import rx.Observable;

import com.reactive.beans.EmployeeInfo;

public class ReactiveJava1 {

	@SuppressWarnings("deprecation")
	public static Observable<EmployeeInfo> getFeed(List<EmployeeInfo> empInf){
		return Observable.create(subscriber->{
			int count=10;
			try {
			//while(count>0){
			while(!subscriber.isUnsubscribed()){
				System.out.println("starting");
				empInf.stream()
				.forEach(subscriber::onNext)
				
				
				;
				System.out.println("entered");
			       
					Thread.sleep(1000);
				}
			}catch (Exception e) {
					subscriber.onError(e);
				}
			//subscriber.onNext(new EmployeeInfo(3, "name", 0.0));
				count--;
			subscriber.onCompleted();
		});
	}
	
	
}
