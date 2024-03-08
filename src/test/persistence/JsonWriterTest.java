package persistence;

import model.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JsonWriterTest{
    //NOTE TO CPSC 210 STUDENTS: the strategy in designing tests for the JsonWriter is to
    //write data to a file and then use the reader to read it back in and check that we
    //read in a copy of what was written out.

    @Test
    void testWriterInvalidFile() {
        try {
            ListOfProfiles prs = new ListOfProfiles();
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyListOfProfiles() {
        try {
            ListOfProfiles prs = new ListOfProfiles();
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyWorkroom.json");
            writer.open();
            writer.write(prs);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyWorkroom.json");
            prs = reader.read();
            assertEquals("ListOfProfiles", prs.getName());
            assertEquals(0, prs.getProfiles().size());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralListOfProfiles() {
        try {
            ListOfProfiles prs = new ListOfProfiles();
            Profile josh = new Profile(("josh"));
            Profile joe = new Profile(("joe"));
            NumberGame numb = new NumberGame();
            TypingGame type = new TypingGame();
            NumberGame numb2 = new NumberGame();
            numb2.setLevel(3);

            josh.addNumGame(numb);
            josh.addNumGame(numb2);
            joe.addNumGame(numb);
            prs.add(josh);
            prs.add(joe);

            JsonWriter writer = new JsonWriter("./data/testWriterGeneralWorkroom.json");
            writer.open();
            writer.write(prs);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralWorkroom.json");
            prs = reader.read();
            assertEquals("ListOfProfiles", prs.getName());
            List<Profile> profs = prs.getProfiles();
            assertEquals(2, profs.size());
            assertEquals("josh",  profs.get(0).getName());
            assertEquals("joe",  profs.get(1).getName());
            assertEquals(3, profs.get(0).getNumGames().get(1).getLevel());

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}