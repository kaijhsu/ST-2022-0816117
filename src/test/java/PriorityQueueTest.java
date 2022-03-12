import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.PriorityQueue;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


public class PriorityQueueTest {


    public static Stream<Arguments> streamProvider(){
        return Stream.of(
                Arguments.of(new int[] {5, 4, 3}, new int[] {3, 4, 4}),
                Arguments.of(new int[] {1, 4, 3}, new int[] {1, 3, 4}),
                Arguments.of(new int[] {1}, new int[] {1}),
                Arguments.of(new int[] {-1, 7, 2, -1}, new int[] {-1, -1, 2, 7}),
                Arguments.of(new int[] {1, 1, 1}, new int[] {1, 1, 1}),
                Arguments.of(new int[] {18, 23, 25, 25}, new int[] {18, 23, 25, 25})

        );
    }

    @ParameterizedTest(name="#{index} - Test with argument={0},{1}")
    @MethodSource("streamProvider")
    public void PriorityQueue_runTest(int[] inputArray, int[] expectArray){
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        int n = inputArray.length;
        for(int i=0; i<n; ++i)
            pq.add(inputArray[i]);

        int[] result = new int[n];

        for(int i=0; i<n; ++i)
            result[i] = pq.poll();

        assertArrayEquals(expectArray, result);
    }

    @Test
    public void addNull_ClassCastException(){
        Exception exception = assertThrows(NullPointerException.class, () -> {
            new PriorityQueue().add(null);
        });
    }

    @Test
    public void initSize0_IllegalArgumentException(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            PriorityQueue<Integer> pq = new PriorityQueue<Integer>(0);
        });
    }

    @Test
    public void forEachNull_NullPointerException() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            PriorityQueue<Integer> pq = new PriorityQueue();
            pq.forEach(null);
        });
    }

//    @Test
//    public void
}
