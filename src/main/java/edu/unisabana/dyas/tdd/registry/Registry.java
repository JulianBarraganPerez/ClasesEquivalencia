package edu.unisabana.dyas.tdd.registry;

import java.util.HashSet;
import java.util.Set;

public class Registry {

    private Set<Integer> registeredIds = new HashSet<>();

    public RegisterResult registerVoter(Person person) {
        if (!person.isAlive()) {
            return RegisterResult.DEAD;
        }
        if (person.getAge() < 18) {
            return RegisterResult.UNDERAGE;
        }
        if (person.getAge() > 120) {
            return RegisterResult.INVALID_AGE;
        }
        if (registeredIds.contains(person.getId())) {
            return RegisterResult.DUPLICATED;
        }

        registeredIds.add(person.getId());
        return RegisterResult.VALID;
    }
}

