package com.reactive;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;

import com.reactive.beans.EmployeeInfo;

public class ReactiveService {
	
	
	
	
	/*public static void main(String[] args) {
		String s="Hai";
		String s1=new String("Hai");
		
		
		System.out.println(s==s1);
		System.out.println(s.equals(s1));
		System.out.println(s==s1.intern());
	}
	
	public void print(){
		System.out.println("Hai");
	}*/
	
	int ecount=0;
	static List<EmployeeInfo> list=null;
	@SuppressWarnings("deprecation")
	public static Observable<EmployeeInfo> getFeed(){
		ReactiveService serv=new ReactiveService();
		list=new ArrayList<EmployeeInfo>();
	
		return Observable.create(subscriber->{
			int count=10;
			try {
			//while(count>0){
			while(!subscriber.isUnsubscribed()){
				System.out.println("Observer");
				list.stream()
				.forEach(subscriber::onNext);
				// subscriber.onNext();
				}
			}catch (Exception e) {
					subscriber.onError(e);
				}
			//subscriber.onNext(new EmployeeInfo(3, "name", 0.0));
				count--;
			subscriber.onCompleted();
		});
	}
	

	EmployeeInfo getEmployee(){
		EmployeeInfo info=null;
			info=new EmployeeInfo(ecount++,"Harish"+ecount,20000+ecount);
		return info;
	}
	
}
