package chutesladder.entities;

import chutesladder.exceptions.OverAgeRestriction;
import chutesladder.exceptions.UnderAgeRestriction;

public class Player {

    String name;
    int age;
    int currentPosition;


    public Player(String name, int age) throws OverAgeRestriction, UnderAgeRestriction {

        PlayerValidation.verifyPlayer(age);
        this.age = age;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }
}
