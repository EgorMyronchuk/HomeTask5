import org.example.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    Main.Human children1 = new Main.Human("Tolik", "Kravech", 5, 200,
            new String[][]{{Main.DayOfWeek.MONDAY.name(), "kindergarten"}, {Main.DayOfWeek.TUESDAY.name(), "kindergarten"}});
    Main.Pet pet2 = new Main.Pet(Main.Species.DOG, "Sharik", 4, 33, new String[]{"Eat", "bark", "play the ball"});
    Main.Human father = new Main.Human("Anton", "Kravech", 30);
    Main.Human mother = new Main.Human("Inna", "Kravech", 27);
    @Test
    public void testToString() {

        String expectedHuman = "Human{name='Tolik', surname='Kravech', year=5, iq=200, schedule=[[MONDAY, kindergarten], [TUESDAY, kindergarten]]}";
        assertEquals(expectedHuman , children1.toString());


        String expectedPet = "DOG{nickname='Sharik', age=4, trickLevel=33, habits=[Eat, bark, play the ball]}";
        assertEquals(expectedPet,pet2.toString());


        Main.Family family = new Main.Family(mother, father, pet2, new Main.Human[]{children1});
        String expectedFamily = "Family{\n" +
                "mother=Human{name='Inna', surname='Kravech', year=27, iq=0, schedule=null},\n" +
                "father=Human{name='Anton', surname='Kravech', year=30, iq=0, schedule=null},\n" +
                "children=[Human{name='Tolik', surname='Kravech', year=5, iq=200, schedule=[[MONDAY, kindergarten], [TUESDAY, kindergarten]]}],\n" +
                "pet=DOG{nickname='Sharik', age=4, trickLevel=33, habits=[Eat, bark, play the ball]}}";
        assertEquals(expectedFamily, family.toString());

    }
    @Test
    public void testDeleteChildByObject1() {
        Main.Human children2 = new Main.Human("Sergei", "Kravech", 3, 210);



        Main.Family family = new Main.Family(mother, father, pet2, new Main.Human[]{children1,children2});

        //перевірте, що дитина дійсно видаляється з масиву `children` (якщо передати об'єкт, еквівалентний хоча б одному елементу масиву);
        assertTrue(family.deleteChild(children2));


    }
    @Test
    public void testDeleteChildByObject2() {

        Main.Human children3 = new Main.Human("Anton", "Kush", 5, 10);


        Main.Family family = new Main.Family(mother, father, pet2, new Main.Human[]{children1});

        //- перевірте, що масив `children` залишається без змін (якщо передати об'єкт, не еквівалентний жодному елементу масиву);
        assertFalse(family.deleteChild(children3));

    }
    @Test
    public void testDeleteChildByIndex1() {
        Main.Human children2 = new Main.Human("Sergei", "Kravech", 3, 210);
        Main.Family family = new Main.Family(mother, father, pet2, new Main.Human[]{children1,children2});
        //Перевірте, що дитина дійсно видаляється з масиву `children` і метод повертає правильне значення;
        assertTrue(family.deleteChild(0));
    }

    @Test
    public void testDeleteChildByIndex2() {
        Main.Family family = new Main.Family(mother, father, pet2, new Main.Human[]{children1});
        //перевірте, що масив `children` залишається без змін (якщо передати індекс, що виходить за діапазон індексів), та метод повертає правильне значення;
        assertFalse(family.deleteChild(20));

    }
    @Test
    public void testAddChild1() {
        Main.Human children3 = new Main.Human("Anton", "Kush", 5, 10);
        Main.Family family = new Main.Family(mother, father, pet2, new Main.Human[]{children1});
        //перевірте, що масив `children` збільшується на один елемент і що цим елементом є саме переданий об'єкт із необхідними посиланнями;
        int beforeAdd = family.getChildren().length;
        family.addChild(children3);


        assertEquals(family.getChildren()[beforeAdd], children3);
    }
    @Test
    public void testCountFamily() {
        Main.Family family = new Main.Family(mother, father, pet2, new Main.Human[]{children1});
        assertEquals(4,family.countFamily());
    }

}
