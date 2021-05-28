package usermanagement.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import usermanagement.entity.Person;

public class TransformServiceTest {

    private TransformService testClass = new TransformService();

    @Test
    public void toUserDomainTest() {
        Person testPerson = new Person();
        testPerson.setfName("fName");
        testPerson.setmName("mName");
        testPerson.setlName("lName");
        testPerson.setCompanyName("CompanyTest");
        testPerson.setPersonId(1234);

        User userTest1 = testClass.toUserDomain(testPerson);

        User userTest2 = new User();
        userTest2.setFirstName(testPerson.getfName());
        userTest2.setLastName(testPerson.getlName());
        userTest2.setUserId(testPerson.getPersonId());
        userTest2.setCompanyName(testPerson.getCompanyName());

        assertEquals(true, userTest1.equals(userTest2));

        assertEquals(userTest1.getFirstName(), userTest2.getFirstName());
        assertEquals(userTest1.getLastName(), userTest2.getLastName());
        assertEquals(userTest1.getCompanyName(), userTest2.getCompanyName());
        assertEquals(userTest1.getUserId(), userTest2.getUserId());

        assertEquals(userTest1.hashCode(), userTest2.hashCode());
    }

    @Test
    public void toUserEntityTest() {
        User testUser = new User();
        testUser.setFirstName("fName");
        testUser.setLastName("lName");
        testUser.setCompanyName("CompanyTest");
        testUser.setUserId(1234);

        Person personTest1 = testClass.toUserEntity(testUser);

        Person personTest2 = new Person();
        personTest2.setfName(testUser.getFirstName());
        personTest2.setlName(testUser.getLastName());
        personTest2.setPersonId(testUser.getUserId());
        personTest2.setCompanyName(testUser.getCompanyName());

        assertEquals(personTest1.getfName(), personTest2.getfName());
        assertEquals(personTest1.getlName(), personTest2.getlName());
        assertEquals(personTest1.getCompanyName(), personTest2.getCompanyName());
        assertEquals(personTest1.getPersonId(), personTest2.getPersonId());

    }
}