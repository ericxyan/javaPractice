package com.eric.practice;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

public class MultithreadingB {
    public static boolean isPrime(long n) {
        return n > 1 && IntStream.rangeClosed(2, (int)Math.sqrt(n)).noneMatch(divisor -> n % divisor == 0);
    }
    
	public static void main(String[] args) {
		List<MyImage> images = MyImage.generateImages(5);
/*		images.parallelStream().forEach(image -> CompletableFuture
				.supplyAsync(image::downloadImage)
				.thenAccept(System.out::println)
				.join());*/
//		System.out.println(Runtime.getRuntime().availableProcessors());
		long start = System.currentTimeMillis();
		IntStream s = IntStream.range(0, 17);
//		System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "20");
/*		s.parallel().forEach(i -> {
		    try { Thread.sleep(100); } catch (Exception ignore) {}
		    System.out.print((System.currentTimeMillis() - start) + " ");
		});*/
		
		ForkJoinPool forkJoinPool = new ForkJoinPool(16);
		forkJoinPool.submit(()-> IntStream.range(0, 17)
				.parallel()
				.forEach(i -> {
				    try { Thread.sleep(100); } catch (Exception ignore) {}
				    System.out.print((System.currentTimeMillis() - start) + " ");
				}))
		.join();
		

	}

	
	
	
}

