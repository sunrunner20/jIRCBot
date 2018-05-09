package jIRCBot;

import java.util.Arrays;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

public class BadWords {

	/* 
	 * Searches for bad words from the sting provided and returns a boolean
	 */
	public boolean badWords(String line) {
		try {
			PropertiesConfiguration properties = new PropertiesConfiguration(GlobalVars.config);
			
			// Reload properties
			properties.reload();
			
			String[] badWords = properties.getString("badWords").toLowerCase().split("\\|");
			String[] wordList = line.toLowerCase().split("\\s+");
			for (String word : wordList) {
				if(Arrays.asList(badWords).contains(word)) {
					return true;
				} else {
					return false;
				}
			}
		} catch (ConfigurationException e) {
			System.out.print(e.getMessage());
		}
		return false;
    }
	
}
