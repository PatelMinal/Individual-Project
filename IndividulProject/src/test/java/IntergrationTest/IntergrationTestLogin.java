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
import com.springboot.individualproject.model.myIndivdualProjectLoginModel;
import com.springboot.individualproject.repository.myIndivdualProjectLoginRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {IndividulProjectApplication.class})
@AutoConfigureMockMvc


public class IntergrationTestLogin {
	
	
	@Autowired
	private MockMvc mvc;

	@Autowired
	private myIndivdualProjectLoginRepository repository;
	
	@Test

	public void findingAndRetrivevingLoginFromDatabase()
			throws Exception { 
				repository.save(new myIndivdualProjectLoginModel("password","minal21"));
				mvc.perform(get("/api/login")
				 .contentType(MediaType.APPLICATION_JSON))
			     .andExpect(status().isOk())
			     .andExpect(content()
			     .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
		         .andExpect(jsonPath("$[0].password", is("password")));



		}
	
	
	@Test
	public void addALoginToDatabaseTest() throws Exception {
		mvc.perform(MockMvcRequestBuilders.post("/api/login").contentType(MediaType.APPLICATION_JSON)
				.content("{\"password\" : \"root\",\"login\" : \"root\"}"))
		.andExpect(status().isOk()).andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.password", is("root")));
	}

				

}
