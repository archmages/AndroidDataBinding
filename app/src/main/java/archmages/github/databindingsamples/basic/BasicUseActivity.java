package archmages.github.databindingsamples.basic;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import archmages.github.databindingsamples.R;
import archmages.github.databindingsamples.databinding.ActivityBasicUseBinding;
import archmages.github.databindingsamples.model.User;

/**
 * .
 * <p/>
 *
 * @author <a href="mailto:lmyu@wisorg.com">David.Yu</a>
 * @version V1.0, 16/12/15
 */
public class BasicUseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityBasicUseBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_basic_use);
        User user = new User("David", "Yu");
        binding.setUser(user);
        binding.setGender("Boy");
    }
}
