package com.text.textManipulator;

import com.text.textElements.Sentence;
import com.text.textElements.Text;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Collections;
import java.util.Comparator;

public class TextManipulator {
    private static final Logger LOGGER = LogManager.getLogger(TextManipulator.class);

    public static Text sortSentencesByLength(Text text){
        LOGGER.info("Sentences were sorted by length");
        Collections.sort(text.getSentences(), Comparator.comparing(Sentence::getLength));
        return text;
    }
}
