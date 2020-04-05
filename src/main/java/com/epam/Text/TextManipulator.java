package com.epam.Text;

import com.epam.Text.TextElements.Sentence;
import com.epam.Text.TextElements.Text;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Collections;
import java.util.Comparator;

public class TextManipulator {
    private static final Logger LOGGER = LogManager.getLogger(TextManipulator.class);

    public static Text sortSentencesByLength(Text text){
        LOGGER.info("Sentences were sorted by length");
        Text sortedText = new Text(text.getSentences());
        Collections.sort(sortedText.getSentences(), Comparator.comparing(Sentence::getLength));
        return sortedText;
    }
}