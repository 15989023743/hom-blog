package com.lemon.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

public class FirstPreFilter extends ZuulFilter {
	
	@Override
	public String filterType() {
		return PRE_TYPE;
	}
	
	@Override
	public int filterOrder() {
		return 0;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		System.out.println("这是第一个自定义Zuul Filter！");
		return null;
	}
}
