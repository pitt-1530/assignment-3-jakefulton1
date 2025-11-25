package edu.pitt.se;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.ArrayList;


public class PlaylistRecommenderTest {
    /*@Before 
    public void setup() {

    }*/
    @Test
    public void testClassifyNull() {
        List<Integer> bpms = null;
        try {
            PlaylistRecommender.classifyEnergy(bpms);
            assert(false);
        }
        catch (NullPointerException e) {
            assert(true);
        }
    }

    @Test
    public void testClassifyEmpty() {
        List<Integer> bpms = new ArrayList<Integer>();
        try {
            PlaylistRecommender.classifyEnergy(bpms);
            assert(false);
        }
        catch (IllegalArgumentException e) {
            assert(true);
        }
    }

    @Test
    public void testClassifyHigh() {
        List<Integer> bpms = new ArrayList<Integer>();
        bpms.add(280);
        bpms.add(0);
        String result = PlaylistRecommender.classifyEnergy(bpms);
        assertEquals("HIGH", result);
    }

    @Test
    public void testClassifyMed() {
        List<Integer> bpms = new ArrayList<Integer>();
        bpms.add(266);
        bpms.add(1);
        bpms.add(33);
        String result = PlaylistRecommender.classifyEnergy(bpms);
        assertEquals("MEDIUM", result);
    }

    @Test
    public void testClassifyLow() {
        List<Integer> bpms = new ArrayList<Integer>();
        bpms.add(300);
        bpms.add(45);
        bpms.add(45);
        bpms.add(6);
        String result = PlaylistRecommender.classifyEnergy(bpms);
        assertEquals("LOW", result);
    }

    @Test
    public void testIsValidTTNull() {
        boolean result = PlaylistRecommender.isValidTrackTitle(null);
        assertFalse(result);
    } 
    
    @Test
    public void testIsValidTTSpecCharacter() {
        boolean result = PlaylistRecommender.isValidTrackTitle("All good execpt for $");
        assertFalse(result);
    } 

    @Test
    public void testIsValidTTZeroLength() {
        boolean result = PlaylistRecommender.isValidTrackTitle("");
        assertFalse(result);
    } 

    @Test
    public void testIsValidTTGoodLength() {
        boolean result = PlaylistRecommender.isValidTrackTitle("All good and works WITH spaces");
        assert(result);
    } 

    @Test
    public void testIsValidTTHighLength() {
        boolean result = PlaylistRecommender.isValidTrackTitle("All good and works WITH spaces but is too long");
        assertFalse(result);
    } 

    @Test
    public void testNormalizeVolumeHigh() {
        int result = PlaylistRecommender.normalizeVolume(120);
        assertEquals(100, result);
    }

    @Test
    public void testNormalizeVolumeLow() {
        int result = PlaylistRecommender.normalizeVolume(-20);
        assertEquals(0, result);
    }

    @Test
    public void testNormalizeVolumeNormal() {
        int result = PlaylistRecommender.normalizeVolume(55);
        assertEquals(55, result);
    }
}
