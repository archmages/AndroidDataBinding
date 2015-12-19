package archmages.github.databindingsamples.utils;

import java.util.Random;

/**
 * .
 * <p/>
 *
 * @author <a href="mailto:lmyu@wisorg.com">David.Yu</a>
 * @version V1.0, 17/12/15
 */
public class RandomUtil {

    private static final Random sRandom = new Random();

    private static final String[] IMAGE_URLS = {
            "http://ww1.sinaimg.cn/large/53488390gw1ez2qjxb7zhj2069069aak.jpg",
            "http://ww1.sinaimg.cn/large/53488390gw1ez2qk67iduj2058058q2y.jpg",
            "http://ww4.sinaimg.cn/large/53488390gw1ez2qkdga3tj2069069aa0.jpg", "http://www.baidu.com"};

    public static String nextImgUrl() {
        return IMAGE_URLS[sRandom.nextInt(IMAGE_URLS.length)];
    }
}
