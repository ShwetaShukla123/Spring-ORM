package com.psl.springdata.product;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import javax.persistence.EntityManager;

import java.util.Arrays;

import org.hibernate.Session;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.transaction.annotation.Transactional;

import com.psl.springdata.product.entities.Product;
import com.psl.springdata.product.repos.ProductRepository;

@SpringBootTest
class ProductdataApplicationTests {
	
	@Autowired
	ProductRepository repository;
	
	@Autowired
	EntityManager entityManager;//to access the low level session object

	@Test
	void contextLoads() {
	}
	
	@Test
	public void testCreate() {
		Product product = new Product();
		product.setId(1);
		product.setName("Iphone");
		product.setDesc("Awesome");
		product.setPrice(40000d);
		
		repository.save(product);
	}
	
	@Test
	public void testRead() {
		Product prod = repository.findById(4).get();
		assertEquals("Dryer", prod.getName());
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>"+ prod.getDesc());
	}
	
	@Test
	public void testUpdate() {
		Product product = repository.findById(1).get();
		product.setPrice(30000d);
		repository.save(product);
	}
	
//	@Test
//	public void testDelete() {
//		if(repository.existsById(1)) {
//			System.out.println("Deleting product.............");
//			repository.deleteById(1);
//		}
//	}
	
	@Test
	public void testCount() {
		System.out.println("Total records................."+repository.count());
	}
	
	@Test
	public void testFindByName() {
		List<Product> products = repository.findByName("Dryer");
		products.forEach(p->System.out.println("\n\n>>>>>>>>>>>>>>>>>>>>>"+p.getPrice()));
	}
	
	@Test
	public void testFindByNameAnddesc() {
		List<Product> products = repository.findByNameAndDesc("TV", "From samsung inc");
		products.forEach(p->System.out.println("\n\n>>>>>>>>>>>>>>>>>>>>>>"+p.getPrice()));
	}
	
	@Test
	public void testFindByPriceGreaterThan() {
		List<Product> products = repository.findByPriceGreaterThan(12000d);
		products.forEach(p->System.out.println("\n\n>>>>>>>>>>>>>>>>>>>>>>"+p.getName()));
	}
	
	@Test
	public void testFindByDescContains() {
		List<Product> products = repository.findByDescContains("apple");
		products.forEach(p->System.out.println("\n\n>>>>>>>>>>>>>>>>>>>>>>"+p.getName()));
	}
	
	@Test
	public void testFindByPriceBetween() {
		List<Product> products = repository.findByPriceBetween(10000d, 30000d);
		products.forEach(p->System.out.println("\n\n>>>>>>>>>>>>>>>>>>>>>>"+p.getName()));
	}
	
	@Test
	public void testFindByDescLike() {
		List<Product> products = repository.findByDescLike("%LG%");
		products.forEach(p->System.out.println("\n\n>>>>>>>>>>>>>>>>>>>>>>"+p.getName()));
	}
	
//	@Test
//	public void testFindByIdIn() {
//		List<Product> products = repository.findByIdIn(Arrays.asList(1, 2, 3));
//		products.forEach(p->System.out.println("\n\n>>>>>>>>>>>>>>>>>>>>>>"+p.getName()));
//	}
	
	@Test
	public void testFindAllPaging() {
		Pageable pageable = PageRequest.of(0, 2);
		Page<Product> pageresults= repository.findAll(pageable);
		pageresults.forEach(p->System.out.println(p.getName()));
	}
	
	@Test
	public void testFindAllSorting() {
		//repository.findAll(Sort.by("name")).forEach(p->System.out.println(p.getName()));
		//repository.findAll(Sort.by("name").descending()).forEach(p->System.out.println(p.getName()));
		repository.findAll(Sort.by(Direction.DESC, "name", "id")).forEach(p->System.out.println(p.getName()));
	}
	
	@Test
	public void testFindAllPagingAndSorting() {
		Pageable pageable = PageRequest.of(0, 2, Direction.DESC, "name");
		repository.findAll(pageable).forEach(p->System.out.println(p.getName()));
	}
	
	@Test
	public void testFindByIn() {
		Pageable pageable = PageRequest.of(0, 2);
		List<Product> products = repository.findByIdIn(Arrays.asList(1, 2,3), pageable);
		products.forEach(p->System.out.println(p.getName()));
	}
	
	
// Level 1 Cache in action
	
	@Test
	@Transactional
	public void testCaching() {
		Session session = entityManager.unwrap(Session.class);
		Product product = repository.findById(1).get();
		repository.findById(1);
		session.evict(product); 
		repository.findById(1);
	}
	
	
}
