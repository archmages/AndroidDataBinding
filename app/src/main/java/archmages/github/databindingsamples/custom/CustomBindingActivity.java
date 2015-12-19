package archmages.github.databindingsamples.custom;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import archmages.github.databindingsamples.MyCustomBinding;
import archmages.github.databindingsamples.R;
import archmages.github.databindingsamples.model.User;
import archmages.github.databindingsamples.utils.Constants;

/**
 * .
 * <p/>
 *
 * @author <a href="mailto:lmyu@wisorg.com">David.Yu</a>
 * @version V1.0, 16/12/15
 */
public class CustomBindingActivity extends AppCompatActivity {

    private MyCustomBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_custom_binding);
        User user = new User("David", "Yu");
        user.setAge(17);
        binding.setUser(user);
        binding.setGender(Constants.FEMALE);
    }

    public void buttonClick(View view){
        binding.tvGender.setVisibility(View.GONE);
    }
}
