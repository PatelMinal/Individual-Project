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
import com.springboot.individualproject.model.myIndivdualProjectBookModel;
import com.springboot.individualproject.repository.myIndivdualProjectBookRepository;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = IndividulProjectApplication.class)
@DataJpaTest

public class RepositoryTest {
	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private myIndivdualProjectBookRepository myRepo;

	@Test
	public void retrieveByIdTest() {
		myIndivdualProjectBookModel model1 = new myIndivdualProjectBookModel("Me before You", "Jojo Moyes",
				"Will needed Lou as much as she needed him, but will her love be enough to save his life?.", "5 Stars", "£5.99");
		entityManager.persist(model1);
		entityManager.flush();
	assertTrue(myRepo.findById(model1.getBook_id()).isPresent());
}

}
