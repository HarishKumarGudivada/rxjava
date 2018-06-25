package com.reactive.demo;

import rx.Observable;
import rx.Subscriber;

import com.reactive.ReactiveService;
import com.reactive.beans.EmployeeInfo;

public class Demo3 {

	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
		
		
		Observable<EmployeeInfo> obs=ReactiveService.getFeed();
		
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
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				EmployeeInfo inf=(EmployeeInfo)arg0;
				System.out.println("Subscriber1 :"+arg0);
				if(inf.getSalary()>20050){
					System.out.println("Thank You I am Done ... No Need to subscribe");
					unsubscribe();
				}
			}
		});

			

		System.out.println("Did i get it");
		Thread.sleep(10000);
	}
}
