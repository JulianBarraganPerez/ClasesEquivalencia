package edu.unisabana.dyas.tdd.registry;

import org.junit.Assert;
import org.junit.Test;

public class RegistryTest {
    private Registry registry = new Registry();

    @Test
    public void validateValidPerson() {
        Person person = new Person("John Doe", 12345, 30, Gender.MALE, true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.VALID, result);
    }
    @Test
    public void validateDeadPerson() {
        Person person = new Person("Jane Doe", 12346, 40, Gender.FEMALE, false);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.DEAD, result);
    }
    @Test
    public void validateUnderagePerson() {
        Person person = new Person("Young Person", 12347, 16, Gender.MALE, true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.UNDERAGE, result);
    }
    @Test
    public void validateInvalidAgePerson() {
        Person person = new Person("Old Person", 12348, 150, Gender.FEMALE, true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.INVALID_AGE, result);
    }
    @Test
    public void validateDuplicatedPerson() {
        Person person = new Person("Duplicated Person", 12349, 30, Gender.MALE, true);
        registry.registerVoter(person); // First registration
        RegisterResult result = registry.registerVoter(person); // Attempt duplicate registration
        Assert.assertEquals(RegisterResult.DUPLICATED, result);
    }
    


}
