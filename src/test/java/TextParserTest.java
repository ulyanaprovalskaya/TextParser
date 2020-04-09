import com.text.textElements.Sentence;
import com.text.textElements.SentenceType;
import com.text.textElements.Text;
import com.text.textElements.Word;
import com.text.textParser.TextParser;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TextParserTest {
    private final static String TEXT = "This morning I get up at a half past six o’clock. It’s still dark. I feel tired. ";

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

    @Test
    public void textToString(){
        Text text = TextParser.parse(TEXT);
        String actualValue = text.toString();
        String expectedValue = TEXT;
        assertEquals(actualValue, expectedValue);
    }
}
