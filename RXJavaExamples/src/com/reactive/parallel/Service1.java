package com.reactive.parallel;

import rx.Observable;
import rx.Subscriber;

import com.reactive.beans.Address;
import com.reactive.beans.EmployeeInfo;

public class Service1 {

	/*
	@SuppressWarnings("deprecation")
	public static Observable<EmployeeInfo> getFeed(){
		return Observable.create(subscriber->{
			try {
			
					Thread.sleep(5000);
					System.out.println("employee");
					EmployeeInfo emp=new EmployeeInfo(10, "Harish", 15000);
			}catch (Exception e) {
					subscriber.onError(e);
				}
		//	subscriber.onCompleted();
		});
	}
	
	
	@SuppressWarnings("deprecation")
	public static Observable<Address> getData(){
		return Observable.create(subscriber->{
			try {
					Thread.sleep(1000);
					System.out.println("address");
					Address emp=new Address();
					emp.setAddressId(1);
					emp.setAddress("Hyderabad");
					emp.setPincode("152246");
			}catch (Exception e) {
					subscriber.onError(e);
				}
			//subscriber.onCompleted();
		});
	}*/
	

	

	@SuppressWarnings("deprecation")
	public static Observable<EmployeeInfo> getFeed() throws Exception {
		/*try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		System.out.println("getFeed ...");
		/*boolean thr = true;
		if(thr) {
			throw new Exception("my error");
		}
		*/
		
		return Observable.create(subscriber->{
			try {
				
				EmployeeInfo emp = new EmployeeInfo(10, "Harish", 15000);
				
				boolean thr = true;
				if(thr) {
					throw new Exception("my error");
				}
			
				
				
				subscriber.onNext(emp);
			
			}catch (Exception e) {
					subscriber.onError(e);
				}
		});

	}
	
	
	@SuppressWarnings("deprecation")
	public static Observable<Address> getData(){
		Address emp=new Address();
		emp.setAddressId(1);
		emp.setAddress("Hyderabad");
		emp.setPincode("152246");
		
		System.out.println("getData ...");

		return Observable.just(emp);
	}
	
}
