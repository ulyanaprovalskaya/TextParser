import com.text.textElements.Text;
import com.text.textManipulator.TextManipulator;
import org.junit.Test;

import static org.junit.Assert.*;

public class TextManipulatorTest {

    private final static String TEXT = "This morning I get up at a half past six o’clock. It’s still dark. I feel tired. " +
            "I went to bed at 1 am and did not sleep enough. If a person doesn’t sleep eight hours, it’s unhealthy, I know." +
            " But today I take an exam. It starts at 9 am and I have to take a 7-hour bus if I want to arrive on time. I’m going" +
            " to take a cold shower, to have a big coffee before getting there. Here I am in the bus. The people around me " +
            "look tired too? I’m not the only one? But I think about my exam. I don’t like mathematics at all, I find it abstract," +
            " and there are too many rules. What’s the sense of all these rules? To tell the truth I don’t understand some of them.";

    private final static String SORTED_TEXT = "It’s still dark. I feel tired. I’m not the only one? But today I take an exam." +
            " Here I am in the bus. But I think about my exam. The people around me look tired too? What’s the sense of all these" +
            " rules? To tell the truth I don’t understand some of them. This morning I get up at a half past six o’clock." +
            " If a person doesn’t sleep eight hours, it’s unhealthy, I know. I went to bed at 1 am and did not sleep enough." +
            " I’m going to take a cold shower, to have a big coffee before getting there. I don’t like mathematics at all," +
            " I find it abstract, and there are too many rules. It starts at 9 am and I have to take a 7-hour bus if I want to" +
            " arrive on time.";
    @Test
    public void sortSentencesByLength() {
        Text actualValue = TextManipulator.sortSentencesByLength(new Text(TEXT));
        Text expectedValue = new Text(SORTED_TEXT);

        assertEquals(actualValue, expectedValue);

    }
}
