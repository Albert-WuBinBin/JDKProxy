package com.wbb.ServiceImpl;

import com.wbb.Service.IService;

public class IServiceImpl implements IService{

	@Override
	public void sayHello(String name) {
		System.out.println("hello:"+name);
		
	}

}
