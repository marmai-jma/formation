package com.bnpparibas.itg.mylibraries.libraries;

import com.bnpparibas.itg.mylibraries.libraries.domain.library.Address;
import com.bnpparibas.itg.mylibraries.libraries.domain.library.Director;
import com.bnpparibas.itg.mylibraries.libraries.domain.library.Library;
import com.bnpparibas.itg.mylibraries.libraries.domain.library.Type;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LibrariesApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void	value_object_should_be_equals_if_same_properties(){
		Director d1 = new Director("1","name1");
		Director d2 = new Director("1","name1");
		Assert.assertEquals(d1,d2);
	}

	@Test
	public void	entitues_should_be_equals_if_same_identity(){
		Address address = new Address(12,"Rue ABC",75000,"Paris");
		Director director = new Director("surname","name");
		Library l1 = new Library(1L, Type.ASSOCIATIVE,address,director,null);
		Library l2 = new Library(1L, Type.NATIONAL,address,director,null);
		Assert.assertEquals(l1,l2);
	}
}
