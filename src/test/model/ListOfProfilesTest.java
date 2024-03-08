package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class ListOfProfilesTest {
    private ListOfProfiles lop;
    private Profile josh;
    private Profile joe;
    private NumberGame numb;
    private TypingGame type;

    @BeforeEach
    void runBefore() {
        lop = new ListOfProfiles();
        josh = new Profile("josh");
        joe = new Profile("joe");
        numb = new NumberGame();
        type = new TypingGame();


    }


    @Test
    void isEmptyTest() {
        assertTrue(lop.isEmpty());
        lop.add(josh);
        assertFalse(lop.isEmpty());
    }

    @Test
    void getProfs() {
        lop.add(josh);
        lop.add(joe);
        ArrayList<Profile> lops = new ArrayList<Profile>();
        lops.add(josh);
        lops.add(joe);
        assertEquals(lops,lop.getProfiles());
    }


    @Test
    void getProf() {
        lop.add(josh);
        lop.add(joe);
        assertEquals(0,lop.getProfPosition("josh"));
        assertEquals(-1,lop.getProfPosition("joshh"));
        assertEquals(josh , lop.get(0));
    }

}