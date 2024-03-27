package org.example;

import java.util.Arrays;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        Human father = new Human("Anton", "Kravech", 30);
        Human father2 = new Human();
        Human father3 = new Human("Egor", "Tereshenko", 26, 145);

        Human mother = new Human("Inna", "Kravech", 27);
        Human mother2 = new Human();
        Human mother3 = new Human("Anna", "Tereshenko", 24, 145);

        Human children1 = new Human("Tolik", "Kravech", 5, 200, new String[][]{{DayOfWeek.MONDAY.name(), "kindergarten"}, {DayOfWeek.TUESDAY.name(), "kindergarten"}});
        Human children2 = new Human("Sergei", "Kravech", 3, 210);

        Pet pet = new Pet(Species.DOG, "Sharik");
        Pet pet2 = new Pet(Species.DOG, "Sharik", 4, 33, new String[]{"Eat", "bark", "play the ball"});
        Family family1 = new Family(mother3, father2);
        Family family = new Family(mother, father, pet2, new Human[]{children1});



        for (int i = 0; i < 1_000_000; i++) {
            new Human();
        }


    }

    public static class Pet {
        private Species species;
        private String nickname;
        private int age;
        private int trickLevel;
        private String[] habits;
        private Family family;

        public Pet() {
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pet pet = (Pet) o;
            return age == pet.age && trickLevel == pet.trickLevel && Objects.equals(species, pet.species) && Objects.equals(nickname, pet.nickname) && Objects.equals(family, pet.family);
        }

        @Override
        public int hashCode() {
            int result = Objects.hash(species, nickname, age, trickLevel, family);
            result = 31 * result + Arrays.hashCode(habits);
            return result;
        }

        public Pet(Species species, String nickname) {
            this.species = species;
            this.nickname = nickname;
        }

        public Pet(Species species, String nickname, int age, int trickLevel, String[] habits) {
            this.species = species;
            this.nickname = nickname;
            this.age = age;
            this.trickLevel = trickLevel;
            this.habits = habits;
        }

        // Геттеры
        public Species getSpecies() {
            return species;
        }

        public Family getFamily() {
            return family;
        }

        public String getNickname() {
            return nickname;
        }

        public int getAge() {
            return age;
        }

        public int getTrickLevel() {
            return trickLevel;
        }

        public String[] getHabits() {
            return habits;
        }

        // Сеттеры
        public void setSpecies(Species species) {
            this.species = species;
        }

        public void setFamily(Family family) {
            this.family = family;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public void setTrickLevel(int trickLevel) {
            this.trickLevel = trickLevel;
        }

        public void setHabits(String[] habits) {
            this.habits = habits;
        }

        public void eat() {
            System.out.println("Я ї'м!");
        }

        public void respond() {
            System.out.printf("Привіт, хазяїн. Я - %s. Я скучив!\n", nickname);
        }

        public void foul() {
            System.out.println("Потрібно добре замести сліди...");
        }

        @Override
        public String toString() {
            return   species.name() + "{" +
                    "nickname='" + nickname + '\'' +
                    ", age=" + age +
                    ", trickLevel=" + trickLevel +
                    ", habits=" + Arrays.toString(habits) +
                    '}';
        }

        @Override
        protected void finalize() {
            System.out.println(this);
        }
    }

    public static class Human {
        private String name;
        private String surname;
        private int year;
        private int iq;
        private Family family;
        private String[][] schedule;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Human human = (Human) o;
            return year == human.year && iq == human.iq && Objects.equals(name, human.name) && Objects.equals(surname, human.surname) && Objects.equals(family, human.family) && Arrays.equals(schedule, human.schedule);
        }

        @Override
        public int hashCode() {
            int result = Objects.hash(name, surname, year, iq, family);
            result = 31 * result + Arrays.hashCode(schedule);
            return result;
        }

        public Human() {
        }

        public Human(String name, String surname, int year) {
            this.name = name;
            this.surname = surname;
            this.year = year;
        }

        public Human(String name, String surname, int year, int iq) {
            this.name = name;
            this.surname = surname;
            this.year = year;
            this.iq = iq;

        }

        public Human(String name, String surname, int year, int iq, String[][] schedule) {
            this.name = name;
            this.surname = surname;
            this.year = year;
            this.iq = iq;
            this.schedule = schedule;
        }

        // Геттеры
        public String getName() {
            return name;
        }

        public String getSurname() {
            return surname;
        }

        public int getYear() {
            return year;
        }

        public int getIq() {
            return iq;
        }

        public Family getFamily() {
            return family;
        }

        public String[][] getSchedule() {
            return schedule;
        }

        // Сеттеры
        public void setName(String name) {
            this.name = name;
        }

        public void setSurname(String surname) {
            this.surname = surname;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public void setIq(int iq) {
            this.iq = iq;
        }

        public void setFamily(Family family) {
            this.family = family;
        }

        public void setSchedule(String[][] schedule) {
            this.schedule = schedule;
        }

        public void greetPet() {
            System.out.printf("Привіт, %s \n", family.pet.nickname);
        }

        public void describePet() {
            if (family.pet.trickLevel > 50) {
                System.out.printf("У мене є %s, їй %d років, він дуже хитрий", family.pet.species, family.pet.age);
            } else {
                System.out.printf("У мене є %s, їй %d років, він майже не хитрий", family.pet.species, family.pet.age);
            }
        }

        @Override
        public String toString() {
            return "Human{" +
                    "name='" + name + '\'' +
                    ", surname='" + surname + '\'' +
                    ", year=" + year +
                    ", iq=" + iq +
                    ", schedule=" + Arrays.deepToString(schedule) +
                    '}';
        }

        @Override
        protected void finalize() {
            System.out.println(this);
        }
    }

    public static class Family {
        Human mother;
        Human father;
        Human[] children;
        Pet pet;

        public Family(Human mother, Human father) {
            this.mother = mother;
            this.father = father;
            mother.setFamily(this);
            father.setFamily(this);
            children = new Human[0];
        }

        public Family(Human mother, Human father, Pet pet, Human[] children) {
            this.mother = mother;
            this.father = father;
            mother.setFamily(this);
            father.setFamily(this);
            this.pet = pet;
            pet.setFamily(this);
            this.children = children;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Family family = (Family) o;
            return Objects.equals(mother, family.mother) && Objects.equals(father, family.father) && Arrays.equals(children, family.children) && Objects.equals(pet, family.pet);
        }

        @Override
        public int hashCode() {
            int result = Objects.hash(mother, father, pet);
            result = 31 * result + Arrays.hashCode(children);
            return result;
        }

        public void setMother(Human mother) {
            this.mother = mother;
        }

        public void setFather(Human father) {
            this.father = father;
        }

        public void setChildren(Human[] children) {
            this.children = children;
        }

        public void setPet(Pet pet) {
            this.pet = pet;
        }

        public Human getMother() {
            return mother;
        }

        public Human getFather() {
            return father;
        }

        public Human[] getChildren() {
            return children;
        }

        public Pet getPet() {
            return pet;
        }

        public void addChild(Human child) {
            Human[] updatedChildren = new Human[children.length + 1];
            for (int i = 0; i < children.length; i++) {
                updatedChildren[i] = children[i];
            }
            updatedChildren[children.length] = child;
            child.setFamily(this);
            children = updatedChildren;
            // не зовсім розумію як чистіше і правильніше це реалізувати
        }

        public boolean deleteChild(int index) {
            if (index < 0 || index >= children.length) {
                return false;
            }
            Human[] updatedChildren = new Human[children.length - 1];
            for (int i = 0, j = 0; i < children.length; i++) {
                if (i != index) {
                    updatedChildren[j++] = children[i];
                }
            }
            children[index] = null;
            children = updatedChildren;
            return true;
            // такаж проблема
        }
        public boolean deleteChild(Human human){
            for (int i = 0; i < children.length; i++) {
                if (children[i].equals(human)) {

                    children[i] = null;
                    return true;
                }
            }
            return false;
            // я розумію що в мене залишаються дірки в масиві
            // і я не можу використати колекції Hash.. але як правильно їх залатати не знаю
        }


        public int countFamily() {
            if (pet != null){
                return 3 + children.length;
            }
            return 2 + children.length;
        }

        @Override
        public String toString() {
            return "Family{" +
                    "\nmother=" + mother +
                    ",\nfather=" + father +
                    ",\nchildren=" + Arrays.toString(children) +
                    ",\npet=" + pet +
                    '}';
        }

        @Override
        protected void finalize() {
            System.out.println(this);
        }

    }
    public enum Species {
        DOG,
        CAT,
        BIRD,
        FISH,
        RABBIT,
        HORSE
    }

    public enum DayOfWeek {
        MONDAY,
        TUESDAY,
        WEDNESDAY,
        THURSDAY,
        FRIDAY,
        SATURDAY,
        SUNDAY
    }

}