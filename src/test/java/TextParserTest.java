import com.epam.Text.TextElements.Sentence;
import com.epam.Text.TextElements.SentenceType;
import com.epam.Text.TextElements.Word;
import com.epam.Text.TextParser;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static org.junit.Assert.*;

public class TextParserTest {
    private final static String TEXT = "This morning I get up at a half past six o’clock. It’s still dark. I feel tired.";

    @Test
    public void parseIntoWords() {
        List<Word> actual = TextParser.parseIntoWords(TEXT);
        assertEquals(17, actual.size());
    }

    @Test
    public void parseIntoSentences() {
        List<Word> words = TextParser.parseIntoWords(TEXT);
        List<Sentence> actual = TextParser.parseIntoSentences(words);
        assertEquals(3, actual.size());
    }

    @Test
    public void getSentenceType() {
        List<Word> words = TextParser.parseIntoWords(TEXT);
        List<Sentence> sentences = TextParser.parseIntoSentences(words);
        for(Sentence s : sentences){
            assertEquals(SentenceType.DECLARATIVE, TextParser.getSentenceType(s));
        }
    }
}
