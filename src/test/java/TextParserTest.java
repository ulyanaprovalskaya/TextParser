import com.text.textElements.Sentence;
import com.text.textElements.SentenceType;
import com.text.textElements.Text;
import com.text.textElements.Word;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TextParserTest {
    private final static String TEXT = " This morning I get up at a half past six o’clock. It’s still dark. I feel tired.\n";

    @Test
    public void textToString(){
        Text text = new Text(TEXT);
        String actualValue = text.toString();
        String expectedValue = TEXT;
        assertEquals(actualValue, expectedValue);
    }
}
