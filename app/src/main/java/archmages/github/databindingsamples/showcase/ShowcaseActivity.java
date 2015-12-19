package archmages.github.databindingsamples.showcase;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import archmages.github.databindingsamples.R;
import archmages.github.databindingsamples.databinding.ActivityShowCaseBinding;
import archmages.github.databindingsamples.model.User;

/**
 * .
 * <p/>
 *
 * @author <a href="mailto:lmyu@wisorg.com">David.Yu</a>
 * @version V1.0, 17/12/15
 */
public class ShowcaseActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityShowCaseBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_show_case);
        binding.setUser(new User("张", "三"));
        binding.tvLastName.setText("hello world");
    }
}
