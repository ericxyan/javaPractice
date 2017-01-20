package com.eric.practice;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

public class MultithreadingA {


	public static void main(String[] args) {

		
		ExecutorService executor = Executors.newFixedThreadPool(4);

		List<MyImage> images = MyImage.generateImages(3);

//		Callable<List<String>> task = () -> images.parallelStream().map(MyImage::downloadImage).collect(Collectors.toList());
		Callable<List<String>> task = () -> images.stream().map(MyImage::downloadImage).collect(Collectors.toList());

		long start = System.currentTimeMillis();
		Future<List<String>> imgFs = executor.submit(task);

		try {
			List<String> imgData = imgFs.get();
			imgData.forEach(System.out::println);
			System.out.format("Time %d", System.currentTimeMillis() - start);
			executor.shutdown();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
