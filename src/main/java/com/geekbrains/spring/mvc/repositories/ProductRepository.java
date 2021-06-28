package com.geekbrains.spring.mvc.repositories;

import com.geekbrains.spring.mvc.model.Box;
import com.geekbrains.spring.mvc.model.Product;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;

@Component("db")
public class ProductRepository {
    private static ProductRepository instance;

    private static Map<Long,Product> list;

    private ProductRepository() {
        list = new HashMap< Long, Product >() {
        };
    }

    public static ProductRepository getInstance() {
        if (instance==null) instance = new ProductRepository();
        return instance;
    }

    @PostConstruct
    public void init() {
        getInstance().creat(new Product(1,"Европа",5621.1f));
        getInstance().creat(new Product(2,"Азия",100.2f));
        getInstance().creat(new Product(3,"Австралия",1691.1f));
        getInstance().creat(new Product(4,"Джинсы",110.1f));
        getInstance().creat(new Product(5,"Рубашка",18.15f));
        getInstance().creat(new Product(101,"Свитер",10.1f));
        getInstance().creat(new Product(1851691,"Барби",1.1f));
        getInstance().creat(new Product(116584,"Санки",5.1f));
        getInstance().creat(new Product(81,"Ледянка",5.5f));
        getInstance().creat(new Product(45,"Машинка",7.1f));

    }



    public List<Product> view(){
        return (list.values().stream().sorted((o1, o2) -> o1.getTitle().compareTo(o2.getTitle())).collect(Collectors.toUnmodifiableList()));

        //return (list.values().stream().sorted((o1, o2) -> o1.getTitle().compareTo(o2.getTitle())).collect(Collectors.toUnmodifiableList()));
    }

    public void creat(Product product){
        getInstance().list.put(product.getId(),product);
    }

    public Product read(long id){
        if(!getInstance().list.containsKey(id)) return null;
        return getInstance().list.get(id);
    }

    public void update(Product product){
        creat(product);
    }

    public void delte(long id){
        getInstance().list.remove(id);
    }

    public long count(){
        return getInstance().list.size();
    }

    public float avr(){
        float sum=0;
        sum = getInstance().list.values().stream().map(s-> s.getCost()).reduce((float) 0, (acc, x) -> acc+x).floatValue();
        return sum/count();
    }

}
