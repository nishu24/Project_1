package com.ers;

import com.ers.exception.RecordNotFoundException;
import com.ers.models.*;
import com.ers.repositories.*;
import com.ers.services.UsersService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * This is the main test class in the reimbursement API Application.
 * This test class method basically has all the tests present in the API. The test methods are present for
 * the all tables present in the database. Some test methods provides all data, and then compares it
 * against all the data values through assertEquals or assertTrue functions.
 */
//@SpringBootTest
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class EmpReimburseSystemTests {
	// Models & repos
	@Autowired
	UsersRepos usersRepos;
	@Autowired
	private TestEntityManager entityManager;

//	@Autowired
//	private Reimbursement reimbursement;
//	private ReimbursementRepositories reimbursementRepositories;

	/**
	 * This method should get list of all the reimbursements, and then tests it's size,
	 * if it is more than > 0 or not.
	 */
	@Test
	public void shouldGetAllReimbursements(){
		List<Reimbursement> reimbursements = reimbursementRepositories.findAll();
		Assertions.assertTrue(reimbursements.size()>0);
	}

	/**
	 * This method should get reimbursements by its unique ID and the compares it values against
	 * the provided values in the assertions.
	 */
	@Test
	public void shouldGetReimbursementById(){

		Reimbursement reimbursement = reimbursementRepositories.findById(1).get();
		Assertions.assertEquals(1, reimbursement.getRid());
	}

	/**
	 * This test method verify all the details from the users table in the database.
	 * For the details to verify, it takes all the parameters from the table and provides it a new
	 * data which is compares against the asserted values.
	 */
	@Test
	void VerifyUsersDetails(){
		Users users = new Users();
		users.setId(4);
		users.setEmail("ravikumar@gmail.com");
		users.setFirstName("Ravi");
		users.setLastName("Kumar");

		Users savedUser = usersRepos.save(users);
		Users existUser = entityManager.find(Users.class, savedUser.getId());

		assertEquals("ravikumar@gmail.com",existUser.getEmail());
		assertEquals("Ravi", existUser.getFirstName());
		assertEquals("Kumar", existUser.getLastName());
		assertEquals(4, existUser.getId());
	}

	@Autowired
	ReimbursementRepositories reimbursementRepositories;

	/**
	 * As mentioned in the above test class method, this again verifies all the details provided from
	 * the Reimbursements tables.
	 */
	@Test
	void VerifyLoginDetails(){
		Reimbursement reimbursement = new Reimbursement();
		reimbursement.setRid(6);
		reimbursement.setR_type_id(2);
		reimbursement.setUser_id(2);
		reimbursement.setDescription("Khavano Kharcho");
		reimbursement.setR_author(2);
		reimbursement.setStatus("Pending");
		reimbursement.setAmount(233.43);
		Reimbursement saved = reimbursementRepositories.save(reimbursement);
		Reimbursement exist = entityManager.find(Reimbursement.class, saved.getRid());
		assertEquals(6,exist.getRid());
		assertEquals(2,exist.getR_type_id());
		assertEquals(233.43,exist.getAmount());
		assertEquals("Khavano Kharcho",exist.getDescription());
		assertEquals(2,exist.getR_author());
		assertEquals("Pending",exist.getStatus());
		assertEquals(2,exist.getUser_id());
	}

	@Autowired
	ReimbursementTypeRepos reimbursementTypeRepos;

	/**
	 * This Test method verfies all the fields against the values in the table reimbursementType
	 */
	@Test
	void VerifyReimbursementType(){
		Reimbursement_Type reimbursement_type = new Reimbursement_Type();
		reimbursement_type.setReimb_type("Miscellaneous");
		reimbursement_type.setType_id(5);
		Reimbursement_Type saved = reimbursementTypeRepos.save(reimbursement_type);
		Reimbursement_Type exist = entityManager.find(Reimbursement_Type.class, saved.getType_id());
		assertEquals("Miscellaneous",exist.getReimb_type());
		assertEquals(5,exist.getType_id());
	}
    @Autowired
    ReimbursementStatusRepositories reimbursementStatusRepositories;
    @Test
    void VerifyStatusDetails(){
        Reimbursement_Status rs = new Reimbursement_Status();
        rs.setStatus("Pending");
        rs.setStatus_id(3);
        Reimbursement_Status saved = reimbursementStatusRepositories.save(rs);
        Reimbursement_Status exist = entityManager.find(Reimbursement_Status.class,saved.getStatus_id());
        assertEquals(3,exist.getStatus_id());
        assertEquals("Pending",exist.getStatus());
    }

    @Autowired
    UsesRolesRepos urr;
    @Test
    void VerifyRoles(){
        UserRoles userRoles = new UserRoles();
        userRoles.setRole("Employee");
        userRoles.setRole_id(1);
        UserRoles saved = urr.save(userRoles);
        UserRoles exist = entityManager.find(UserRoles.class,saved.getRole_id());
        assertEquals(1,exist.getRole_id());
        assertEquals("Employee", exist.getRole());
    }

	@Test
	public void TestSomethingsOut(){
		Reimbursement_Status reimbursement_status = Reimbursement_Status.builder()
				.status("Pending")
				.status_id(1)
				.build();
		reimbursementStatusRepositories.save(reimbursement_status);
		assertTrue(reimbursement_status.getStatus_id()>0);
	}

	Reimbursement_Status reimbursement_status = Reimbursement_Status.builder()
			.status_id(4)
			.status("Rejected")
			.build();
	@Test
	void shouldGetId() {
		assertEquals(4, reimbursement_status.getStatus_id());
	}
	@Test
	void shouldGetStatus() {
		assertEquals("Rejected", reimbursement_status.getStatus());
	}

	UserRoles userRoles = UserRoles.builder()
			.role_id(5)
			.role("Employee")
			.build();

	@Test
	void shouldGetURId() {
		assertEquals(5, userRoles.getRole_id());
	}
	@Test
	void shouldGetRoles() {
		assertEquals("Employee", userRoles.getRole());
	}

	Reimbursement reimbursement = Reimbursement.builder()
			.amount(1245.12)
			.r_author(2)
			.r_type_id(4)
			.status("Pending")
			.description("Expenses For Lunch Break")
			.rid(1)
			.user_id(4)
			.build();

	@Test
	void shouldGetRId() {
		assertEquals(1, reimbursement.getRid());
	}
	@Test
	void shouldGetAmt() {
		assertEquals(1245.12, reimbursement.getAmount());
	}
	@Test
	void shouldGetRAuth() {
		assertEquals(2, reimbursement.getR_author());
	}
	@Test
	void shouldGetRType() {
		assertEquals(4, reimbursement.getR_type_id());
	}
	@Test
	void shouldGetRStatus() {
		assertEquals("Pending", reimbursement.getStatus());
	}
	@Test
	void shouldGetRDesc() {
		assertEquals("Expenses For Lunch Break", reimbursement.getDescription());
	}
	@Test
	void shouldGetRUserID() {
		assertEquals(4, reimbursement.getUser_id());
	}
}