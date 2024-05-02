package com.david.reactiveprogramming;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;
import reactor.util.function.Tuple3;

import java.time.Duration;

@SpringBootTest
class ReactiveProgrammingApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void testMonoBasic(){

		Mono<String> error = Mono.error(new RuntimeException("Mono which produces error when subscribe to him"));

		Mono<String> data = Mono
				.just("Mono is a publisher with 0 or 1 item")
				.log()
				.then(error);

		//consume the mono by subscribing
		data.subscribe(System.out::println);

		//error.subscribe(System.out::println);
	}
	@Test
	void testMonoTuples(){
		Mono<String> m1 = Mono.just("Hello");
		Mono<String> m2 = Mono.just("world");
		Mono<String> m3 = Mono.just("in Spain");

		Mono<Tuple2<String, String>> tuple2Mono = Mono.zip(m1, m2);

		//zip.subscribe(x -> x.forEach(System.out::println));
		//zip.subscribe(x -> System.out.println(x));
		//tuple2Mono.subscribe(x -> x.getT1());

		Mono<Tuple3<String, String, String>> tuple3Mono = Mono.zip(m1, m2, m3);
		tuple3Mono.subscribe(System.out::println);
	}

	@Test
	void testMonoMapAndFlux() throws InterruptedException {
		Mono<String> m1 = Mono.just("Hello");
		Mono<String> m2 = Mono.just("world");

		Mono<String> map = m1.map(String::toUpperCase);
		//map.subscribe(System.out::println);

		Mono<String[]> flatMap = m1.flatMap(x -> Mono.just(x.split("")));
//		flatMap.subscribe(x -> {
//			for (String s: x){
//				System.out.println(s);
//			}
//		});
		//Publisher that emits 0 to N elements, and then completes (successfully or with an error).
		Flux<String> stringFlux = m1.flatMapMany(x -> Flux.just(x.split("")));
		//stringFlux.subscribe(System.out::println);

		Flux<String> concatWith = m1.concatWith(m2)
				.log()
				.delayElements(Duration.ofSeconds(2));

		Thread.sleep(2000);
		concatWith.subscribe(x -> {
			System.out.println(Thread.currentThread().getName());
			System.out.println(x);
		});

	}

}
