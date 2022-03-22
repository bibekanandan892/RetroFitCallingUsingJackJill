package com.example.myapplicationtestnew.modelForV1AndV2;

import com.google.gson.annotations.SerializedName;

public class ModelV1Response{

	@SerializedName("hello")
	private String hello;

	public void setHello(String hello){
		this.hello = hello;
	}

	public String getHello(){
		return hello;
	}
}