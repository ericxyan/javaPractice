package com.eric.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MyImage {
	private String name;
	private String url;
	private int size;
	private String data;

	public MyImage() {
	}

	public MyImage(String name, String url, int size, String data) {
		this.name = name;
		this.url = url;
		this.size = size;
		this.data = data;
	}

	public String downloadImage() {
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			throw new IllegalStateException("task interrupted", e);
		}
		return toString();
	}
	
	
	
	@Override
	public String toString() {
		return "MyImage [name=" + name + ", url=" + url + ", size=" + size + ", data=" + data + "]";
	}

	public static List<MyImage> generateImages(int num){
		List<MyImage> images = new ArrayList<MyImage>();
		String name, url, data;
		int size;
		
		for(int i = 0; i < num; i++){
			name = "image" + i;
			url = "url" + i;
			size = i;
			data = "data" + i;
			
			images.add(new MyImage(name, url, size, data));
		}
		
		return images;
	}

}