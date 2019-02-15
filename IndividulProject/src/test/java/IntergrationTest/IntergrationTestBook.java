package IntergrationTest;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.springboot.individualproject.IndividulProjectApplication;
import com.springboot.individualproject.model.myIndivdualProjectBookModel;
import com.springboot.individualproject.repository.myIndivdualProjectBookRepository;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = {IndividulProjectApplication.class})
@AutoConfigureMockMvc

public class IntergrationTestBook {
	
	@Autowired
	private MockMvc mvc;

	@Autowired
	private myIndivdualProjectBookRepository repository;
	
	@Test
	
	public void findingAndRetrivevingLoginFromDatabase()
			throws Exception { 
				repository.save(new myIndivdualProjectBookModel("Me Before You","Jojo Moyes", "\"Will needed Lou as much as she needed him, but will her love be enough to save his life?", "5 Stars","£5.99"));
				mvc.perform(get("/api/book")
				 .contentType(MediaType.APPLICATION_JSON))
			     .andExpect(status().isOk())
			     .andExpect(content()
			     .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
		         .andExpect(jsonPath("$[0].title", is("Me Before You")));



}
	
	@Test
	public void addABookToDatabaseTest() throws Exception {
		mvc.perform(MockMvcRequestBuilders.post("/api/book").contentType(MediaType.APPLICATION_JSON)
				.content("{\"title\" : \"Sapiens: A Brief History of Humankind\",\"author\" : \"Yuval Noah Harari\", \"description\": \"100,000 years ago, at least six human species inhabited the earth. Today there is just one. Us. Homo sapiens. How did our species succeed in the battle for dominance? Why did our foraging ancestors come together to create cities and kingdom?\", \"rating\" : \"5 Stars\", \"price\" : \"£8.99\"}"))
		.andExpect(status().isOk()).andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.title", is("root")));
	}
}