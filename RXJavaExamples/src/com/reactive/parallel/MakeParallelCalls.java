package com.reactive.parallel;

import rx.Observable;

import com.reactive.beans.Address;
import com.reactive.beans.EmployeeInfo;
import com.reactive.beans.EmployeeSummary;

public class MakeParallelCalls {
	
	public static void main(String[] args) throws Exception  {
		
		Observable<EmployeeSummary> obj=callReactiveCalls();
		System.out.println(obj.toBlocking().single());
		
		//SoftReference<MakeParallelCalls>  newobj=new MakeParallelCalls();
	}

	
	
	public static Observable<EmployeeSummary> callReactiveCalls() throws Exception {
		

		Service1 service=new Service1();
		
		Observable<EmployeeInfo> obs=service.getFeed();
		
System.out.println("getFeed called");
		
		Observable<Address> obs1=service.getData();
		
		System.out.println("getData called");

		
		Observable<EmployeeSummary> empSummaryAggregate;
		
		
		empSummaryAggregate = Observable.zip(obs.onErrorReturn((error) -> {
			EmployeeInfo empInfo = new EmployeeInfo();
			empInfo.setError("employee error");
            return empInfo;
        }),
        obs1.onErrorReturn((error) -> {
			Address add = new Address();
			add.setError("address error");
            return add;
        }),
        (obj1, obj2) -> {
        	
        	System.out.println("Agggregation started");

        	
        	EmployeeSummary empSum = new EmployeeSummary();           
            
        	empSum.setId(obj1.getId());
        	empSum.setName(obj1.getName());
        	empSum.setSalary(obj1.getSalary());
        	empSum.setAddressId(obj2.getAddressId());
        	empSum.setAddress(obj2.getAddress());
        	empSum.setError(obj1.getError() + ", "+ obj2.getError());
        	System.out.println("EmployeeSummary in aggreagator :\n"+empSum.toString());
            return empSum;
        });
		
		
		return empSummaryAggregate;
	}
}
