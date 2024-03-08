package persistence;

import model.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JsonReaderTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            ListOfProfiles prs = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyWorkRoom() {
        JsonReader reader = new JsonReader("./data/testWriterEmptyWorkroom.json");
        try {
            ListOfProfiles prs = reader.read();
            assertEquals("ListOfProfiles", prs.getName());
            assertEquals(0, prs.getProfiles().size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralWorkRoom() {
        JsonReader reader = new JsonReader("./data/testWriterGeneralWorkRoom.json");
        try {
            ListOfProfiles prs = reader.read();
            assertEquals("ListOfProfiles", prs.getName());
            List<Profile> profs = prs.getProfiles();
            assertEquals(2, profs.size());
            assertEquals("josh",  profs.get(0).getName());
            assertEquals("joe",  profs.get(1).getName());
            assertEquals(3, profs.get(0).getNumGames().get(1).getLevel());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}