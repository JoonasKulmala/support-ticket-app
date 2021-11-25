package fi.kulmala.support;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import fi.kulmala.support.web.TicketController;
import fi.kulmala.support.web.UserController;
import fi.kulmala.support.web.UserDetailServiceImpl;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PalvelinohjelmointiApplicationTests {

	@Autowired
	private TicketController ticketcontroller;
	@Autowired
	private UserController usercontroller;
	@Autowired
	private UserDetailServiceImpl userdetailserviceimpl;

	// Controller smoke tests
	@Test
	public void contextLoadsTicketController() throws Exception {
		assertThat(ticketcontroller).isNotNull();
	}

	@Test
	public void contextLoadsUserController() throws Exception {
		assertThat(usercontroller).isNotNull();
	}

	@Test
	public void contextLoadsUserDetailServiceImpl() throws Exception {
		assertThat(userdetailserviceimpl).isNotNull();
	}

}