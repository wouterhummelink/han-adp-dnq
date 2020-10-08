package han.adp.dnq;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class DivideAndConquerTest {
    
    @Test
    public void subArrayTest() {
        List<Integer> subject = Arrays.asList(
            13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7);
        DivideAndConquer divideAndConquer = new DivideAndConquer();
        DivideAndConquer.SubArrayResult subArrayResult = divideAndConquer.maxSubArray(subject);
        System.out.println(subArrayResult);
        assertEquals(divideAndConquer.new SubArrayResult(7, 10, 43) , subArrayResult);
    }
}
