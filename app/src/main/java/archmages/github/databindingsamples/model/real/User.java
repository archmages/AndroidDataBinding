package archmages.github.databindingsamples.model.real;

/**
 * .
 * <p/>
 *
 * @author <a href="mailto:lmyu@wisorg.com">David.Yu</a>
 * @version V1.0, 16/12/15
 */
public class User {

    public final String firstName;

    public final String lastName;

    private String mobile;

    private String email;

    private String idNo;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
