package archmages.github.databindingsamples.alias;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import archmages.github.databindingsamples.R;
import archmages.github.databindingsamples.databinding.ActivityAliasBindingBinding;
import archmages.github.databindingsamples.model.real.User;

/**
 * .
 * <p/>
 *
 * @author <a href="mailto:lmyu@wisorg.com">David.Yu</a>
 * @version V1.0, 16/12/15
 */
public class AliasBindingActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityAliasBindingBinding bindingBinding = DataBindingUtil.setContentView(this, R.layout.activity_alias_binding);
        bindingBinding.setUser(new User("David", "Yu"));
    }
}
