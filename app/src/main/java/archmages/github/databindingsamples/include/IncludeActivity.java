package archmages.github.databindingsamples.include;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import archmages.github.databindingsamples.R;
import archmages.github.databindingsamples.databinding.ActivityIncludeBinding;
import archmages.github.databindingsamples.model.User;

/**
 * .
 * <p/>
 *
 * @author <a href="mailto:lmyu@wisorg.com">David.Yu</a>
 * @version V1.0, 17/12/15
 */
public class IncludeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityIncludeBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_include);
        binding.setUser(new User("David", "Yu"));
    }
}
