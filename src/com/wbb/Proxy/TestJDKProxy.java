package com.wbb.Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.wbb.Service.IService;
import com.wbb.ServiceImpl.IServiceImpl;

public class TestJDKProxy {

	public static void main(String[] args) {
		IService service = (IService) Proxy.newProxyInstance(TestJDKProxy.class.getClassLoader(), 
				new Class[] {IService.class}, new InvocationHandler() {
					
					IServiceImpl serviceImpl = new IServiceImpl();
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						System.out.println("调用前");
						Object object = method.invoke(serviceImpl, args);
						System.out.println("调用后");
						return object;
					}
				});

		service.sayHello("wbb");
	}
}
