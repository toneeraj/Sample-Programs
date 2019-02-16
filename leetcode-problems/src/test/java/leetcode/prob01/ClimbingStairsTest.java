package leetcode.prob01;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class ClimbingStairsTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testClimbStairs_2() {
	ClimbingStairs cs = new ClimbingStairs();
	assertThat(cs.climbStairs(2)).isEqualTo(2);
    }
    
    @Test
    public void testClimbStairs_3() {
	ClimbingStairs cs = new ClimbingStairs();
	assertThat(cs.climbStairs(3)).isEqualTo(3);
    }

}
