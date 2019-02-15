package RepositoryTest;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.springboot.individualproject.IndividulProjectApplication;
import com.springboot.individualproject.model.myIndivdualProjectLoginModel;
import com.springboot.individualproject.repository.myIndivdualProjectLoginRepository;



@RunWith(SpringRunner.class)
@ContextConfiguration(classes = IndividulProjectApplication.class)
@DataJpaTest
public class RepositoryTestLogin {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private myIndivdualProjectLoginRepository myRepo;

	@Test
	public void retrieveByIdTest() {
		myIndivdualProjectLoginModel model1 = new myIndivdualProjectLoginModel("password", "minal21");
		entityManager.persist(model1);
		entityManager.flush();
		assertTrue(myRepo.findById(model1.getLogin_id()).isPresent());

	}

}
