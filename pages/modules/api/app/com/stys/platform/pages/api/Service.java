package com.stys.platform.pages.api;

/** Generic pages service */
public interface Service<R, S, D> {

	/** Get result by selector */
	public R get(S selector);

	/** Put data by selector */
	public R put(S selector, D data);

}