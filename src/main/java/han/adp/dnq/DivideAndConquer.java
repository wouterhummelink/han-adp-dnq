package han.adp.dnq;

import java.net.HttpURLConnection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import lombok.Value;

public class DivideAndConquer {
    @Value
    public final class SubArrayResult implements Comparable<SubArrayResult> {
        int min, max, sum;

        @Override
        public int compareTo(SubArrayResult other) {
            return Integer.compare(this.sum, other.sum);
        }


    }

    public SubArrayResult maxSubArray(List<Integer> list) {
        return maxSubArray(list, 0, list.size()-1);
    }

    public SubArrayResult maxSubArray(List<Integer> list, int low, int high) {
        if (high==low) {
            return new SubArrayResult(low, high, list.get(high)); 
        } else {
            int mid = (low+high)/2;
            SubArrayResult lowResult = maxSubArray(list, low, mid);
            SubArrayResult highResult = maxSubArray(list, mid+1, high);
            SubArrayResult xResult = maxXSubArray(list, low, mid, high);
            return Collections.max(Arrays.asList(lowResult, highResult, xResult));
        }
    }

    /**
      Search left and right for largest subarray and sum the result
    */
    private SubArrayResult maxXSubArray(List<Integer> list, int low, int mid, int high) {
        int leftSum = Integer.MIN_VALUE;
        int sum = 0;
        int maxLeft = 0;
        for( int i = mid; i>=low; i--) {
            sum = sum + list.get(i);
            if (sum > leftSum) {
                leftSum = sum;
                maxLeft = i;
            }
        }
        int rightSum = Integer.MIN_VALUE;
        sum = 0;
        int maxRight = mid+1;
        for( int i=mid+1; i <= high; i++) {
            sum = sum + list.get(i);
            if (sum > rightSum) {
                rightSum = sum;
                maxRight = i;
            }
        }
        return new SubArrayResult(maxLeft, maxRight, leftSum+rightSum);
    }
}
