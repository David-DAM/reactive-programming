package com.david.reactiveprogramming.controller;

import com.david.reactiveprogramming.domain.Product;
import com.david.reactiveprogramming.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController {

    public final ProductService productService;

    @PostMapping
    public ResponseEntity<Mono<Product>> create(@RequestBody Product product){
        Mono<Product> saved = productService.save(product);

        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Mono<Product>> update(Product product,Long id){
        Mono<Product> updated = productService.update(product, id);

        return new ResponseEntity<>(updated,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mono<Product>> findById(@PathVariable Long id){

        Mono<Product> product = productService.findById(id);

        return new ResponseEntity<>(product,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Flux<Product>> findAll(){

        Flux<Product> products = productService.findAll();

        return new ResponseEntity<>(products,HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Mono<Void>> delete(Long id){
        Mono<Void> deleted = productService.delete(id);

        return new ResponseEntity<>(deleted,HttpStatus.NO_CONTENT);
    }

}
