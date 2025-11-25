package edu.pitt.se;

import java.util.List;

public class PlaylistRecommender {

    public static String classifyEnergy(List<Integer> bpms) {
        // TODO: Implement classifyEnergy()
        if (bpms == null) {
            throw new NullPointerException("List<Integer> bpms is null");
        }

        if (bpms.size() == 0) {
            throw new IllegalArgumentException("List<Integer> bpms is empty");
        }
        
        int total = 0;
        for (Integer bpm : bpms) {
            total += bpm;
        }
        int size = bpms.size();
        int avgBpm = total / size;

        if (avgBpm >= 140)
            return "HIGH";
        else if (avgBpm >= 100)
            return "MEDIUM";
        else //(avgBpm < 100)
            return "LOW";
    }

    public static boolean isValidTrackTitle(String title) {
        // TODO: Implement isValidTrackTitle()
        if (title == null)
            return false;
        
        for (char letter : title.toCharArray()) { //Check that all characters are either letters or spaces
            int value = (int) letter; 
            if (!(value >=65 && value <= 90 || value >= 97 && value <=122 || value == 32))
                return false;
        }

        if (title.length() < 1 || title.length() > 30)
            return false;

        return true;
    }

    public static int normalizeVolume(int volumeDb) {
        // TODO: Implement normalizeVolume()
        if (volumeDb > 100)
            return 100;
        else if (volumeDb < 0)
            return 0;
        else
            return volumeDb;
    }
}
